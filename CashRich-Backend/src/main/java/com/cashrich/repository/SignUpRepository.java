package com.cashrich.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.cashrich.entity.SignUpDetails;
import com.cashrich.entity.UserDetails;

@Component
public interface SignUpRepository extends JpaRepository<SignUpDetails, Long>{
	
	//Optional<SignUpDetails> findByUsername(String username);
	
	Optional<SignUpDetails> findByEmail(String email);
	
	Optional<SignUpDetails> findById(Long id);
	
	Optional<SignUpDetails> findByUsernameAndPassword(String username, String password);
	
	@Query(value = "SELECT password FROM user_details WHERE username = ?", nativeQuery = true)
	String findPasswordByUsername(String username);

}
