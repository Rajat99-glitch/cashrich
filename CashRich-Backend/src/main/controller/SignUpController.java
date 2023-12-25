package com.cashrich.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.entity.SignUpDetails;
import com.cashrich.service.SignUpService;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/signup")
	@Transactional
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDetails details) throws Exception{
		
		if (this.signUpService.emailExists(details.getEmail())) {
	        return ResponseEntity.badRequest().body("Email is already taken!");
	    }
	    
	    try {
	    	SignUpDetails signup = new SignUpDetails();
	    	signup.setFirstName(details.getFirstName());
	    	signup.setLastName(details.getLastName());
	    	signup.setEmail(details.getEmail());
	    	signup.setMobileNumber(details.getMobileNumber());
	    	signup.setUsername(details.getUsername());
		    signup.setPassword(new BCryptPasswordEncoder().encode(details.getPassword()));
	        this.signUpService.saveSignUpUserDetails(signup);
	        return ResponseEntity.ok("User registered successfully!");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
	    }
	}
}
