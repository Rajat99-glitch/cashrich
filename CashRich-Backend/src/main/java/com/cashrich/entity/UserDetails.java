package com.cashrich.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Entity
@Data
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{4,15}$", message = "Username must contain only characters and digits")
    @Size(min = 4, max = 15, message = "Username length must be between 4 and 15 characters")
	private String username;
	

	@NotBlank
	//@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password must be 8 to 15 characters with at least one uppercase letter, one lowercase letter, and one special character")
	//@Size(min = 8, max = 15, message = "Password length must be between 8 and 15 characters")
	private String password;
	
	@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL, optional = false)
	private SignUpDetails signUpDetails;
	
}
