package com.cashrich.service;

import com.cashrich.entity.SignUpDetails;

public interface SignUpService {
	
	//public SignUpDetails getUserDetailsByUsername(String username) throws UserNameNotFoundException;

	public SignUpDetails saveSignUpUserDetails(SignUpDetails signUpDetails);
	
	//public boolean userNameExists(String username);
	
	public boolean emailExists(String email);

}
