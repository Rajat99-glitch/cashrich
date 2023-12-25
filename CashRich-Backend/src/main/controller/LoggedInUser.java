package com.cashrich.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cashrich.entity.SignUpDetails;
import com.cashrich.entity.UserDetails;
import com.cashrich.exceptions.UserNotFoundException;
import com.cashrich.repository.SignUpRepository;

@RestController
public class LoggedInUser {

	@Autowired
	private SignUpRepository userRepo;

	@GetMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDetails userDetails) {
		
		return null;
	}

	@PutMapping("/update-user")
	@Transactional
	public ResponseEntity<?> updateUser(@RequestBody SignUpDetails userDetails, @RequestParam Long userId)
			throws UserNotFoundException {
		
		Optional<SignUpDetails> existingUser = userRepo.findById(userId);
		if (existingUser.isEmpty()) {
			ResponseEntity.badRequest().body("User not found with ID: " + userId);
			throw new UserNotFoundException("User not found with ID: " + userId);
		}
		if (userDetails.getFirstName() != null) {
			existingUser.get().setFirstName(userDetails.getFirstName());
		}
		if (userDetails.getLastName() != null) {
			existingUser.get().setLastName(userDetails.getLastName());
		}
		if (userDetails.getMobileNumber() != null) {
			existingUser.get().setMobileNumber(userDetails.getMobileNumber());
		}
		if (userDetails.getUsername() != null) {
			existingUser.get().setUsername(userDetails.getUsername());
		}
		if (userDetails.getEmail() != null) {
			existingUser.get().setEmail(userDetails.getEmail());
		}
		if (userDetails.getPassword() != null) {
			existingUser.get().setFirstName(userDetails.getPassword());
		}
		this.userRepo.save(existingUser.get());
		return ResponseEntity.ok().body("User Updated Successfully......");
	}

}
