package com.cashrich.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cashrich.entity.SignUpDetails;

@Component
public interface SignUpRepository extends JpaRepository<SignUpDetails, Long>{
	
	//Optional<SignUpDetails> findByUsername(String username);
	
	Optional<SignUpDetails> findByEmail(String email);
	
	Optional<SignUpDetails> findById(Long id);

}
