package com.cashrich.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "third_party_api_logs")
@Data
public class ApiLogsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 4, max = 15, message = "Username length must be between 4 and 15 characters")
	@Column(name = "called_by")
	private String userId;
	
	@NotNull
	private String response;
	
	@Column(name = "api_call_timestamp")
	private LocalDateTime apiCallTimestamp;
}
