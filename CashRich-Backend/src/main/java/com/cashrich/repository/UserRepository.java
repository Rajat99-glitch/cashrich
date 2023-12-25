package com.cashrich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.entity.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Long>{

}
