package com.cashrich.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cashrich.entity.SignUpDetails;
import com.cashrich.repository.SignUpRepository;
import com.cashrich.service.SignUpService;

@Service
@Transactional
public class SignUpServiceImpl implements SignUpService{

	@Autowired
	private SignUpRepository signUpRepository;


	@Override
	public SignUpDetails saveSignUpUserDetails(SignUpDetails signUpDetails) {
		return signUpRepository.save(signUpDetails);
	}


	@Override
	public boolean emailExists(String email) {
		return signUpRepository.findByEmail(email).isPresent();
	}

}
