package com.cashrich.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashrich.entity.UserDetails;
import com.cashrich.repository.UserRepository;

@Service
public class LoginUserServiceImpl {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Transactional
	public UserDetails saveLoginDetails(UserDetails userDetails) {
		return userRepo.save(userDetails);
	} 

}
