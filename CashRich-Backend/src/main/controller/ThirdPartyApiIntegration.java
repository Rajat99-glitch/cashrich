package com.cashrich.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.cashrich.entity.ApiLogsEntity;
import com.cashrich.repository.ThirdPartyApiRepo;

@RestController
public class ThirdPartyApiIntegration {
	
	@Autowired
	private WebClient.Builder webclientBuilder;
	
	@Autowired
	private ThirdPartyApiRepo thirdPartyRepo;
	
	public final String API_KEY_VALUE = "27ab17d1-215f-49e5-9ca4-afd48810c149";
	
	@GetMapping("/get-api-response")
	public ResponseEntity<?> thirdPartyApiResponse(@RequestParam String symbol, @RequestParam String userId)
	{
		try {
			String response = webclientBuilder.build()
							.get()
							.uri("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?symbol=" +symbol)
							.header("X-CMC_PRO_API_KEY", API_KEY_VALUE)
							.retrieve()
							.bodyToMono(String.class)
							.block();
			
			ApiLogsEntity logs = new ApiLogsEntity();
			logs.setApiCallTimestamp(LocalDateTime.now());
			logs.setUserId(userId);
			logs.setResponse(response);
			thirdPartyRepo.save(logs);
			
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("There is some issues while fetching data");
		}
		
	}
}
