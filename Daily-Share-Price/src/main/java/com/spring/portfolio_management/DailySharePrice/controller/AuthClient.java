package com.cognizant.portfolio_management.DailySharePrice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.portfolio_management.DailySharePrice.model.AuthResponse;

@FeignClient(name = "authorization-service", url = "http://localhost:9095")
public interface AuthClient {

	@RequestMapping(value = "/validate", method = RequestMethod.GET)
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}
