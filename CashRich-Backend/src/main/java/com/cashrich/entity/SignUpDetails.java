package com.cashrich.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
@Entity
@Table(name = "user_details", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class SignUpDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull
	private Long mobileNumber;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{4,15}$", message = "Username must contain only characters and digits")
    @Size(min = 4, max = 15, message = "Username length must be between 4 and 15 characters")
	private String username;
	

	@NotBlank
	//@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password must be 8 to 15 characters with at least one uppercase letter, one lowercase letter, and one special character")
	//@Size(min = 8, max = 15, message = "Password length must be between 8 and 15 characters")
	private String password;
}
