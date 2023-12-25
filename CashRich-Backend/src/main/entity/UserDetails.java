package com.cashrich.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDetails {
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{4,15}$", message = "Username must contain only characters and digits")
    @Size(min = 4, max = 15, message = "Username length must be between 4 and 15 characters")
	private String username;
	

	@NotBlank
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must be 8 to 15 characters with at least one uppercase letter, one lowercase letter, and one special character")
	//@Size(min = 8, max = 15, message = "Password length must be between 8 and 15 characters")
	private String password;

}
