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
import com.cashrich.entity.UserDetails;
import com.cashrich.repository.UserRepository;
import com.cashrich.service.SignUpService;
import com.cashrich.service.impl.LoginUserServiceImpl;

@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@Autowired
	private LoginUserServiceImpl loginService;
	
	@PostMapping("/signup")
	@Transactional
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDetails signUpDetails) throws Exception{
		
		if (this.signUpService.emailExists(signUpDetails.getEmail())) {
	        return ResponseEntity.badRequest().body("Email is already taken!");
	    }

	    // Creating a new UserDetails entity
	    UserDetails user = new UserDetails();
	    user.setUsername(signUpDetails.getUserDetails().getUsername());
	    user.setPassword(new BCryptPasswordEncoder().encode(signUpDetails.getUserDetails().getPassword()));

	    // Setting the UserDetails in SignUpDetails
	    signUpDetails.setUserDetails(user);

	    try {
	        // Saving the UserDetails before SignUpDetails to resolve the transient entity issue
	        loginService.saveLoginDetails(user);
	        this.signUpService.saveSignUpUserDetails(signUpDetails);
	        return ResponseEntity.ok("User registered successfully!");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering user");
	    }
        //return ResponseEntity.ok("User registered successfully!");

	}
}
