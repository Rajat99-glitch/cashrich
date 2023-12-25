package com.cashrich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cashrich.entity.ApiLogsEntity;

public interface ThirdPartyApiRepo extends JpaRepository<ApiLogsEntity, Long>{

}
