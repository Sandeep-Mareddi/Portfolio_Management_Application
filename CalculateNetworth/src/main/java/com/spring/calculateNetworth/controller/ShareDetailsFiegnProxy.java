package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.calculateNetworth.model.StockDetails;

@FeignClient(name="ShareDetailsService",url="http://localhost:8091")
public interface ShareDetailsFiegnProxy {
	
	@GetMapping("/dailyallshareprice")
	public List<StockDetails> findAll(@RequestHeader("Authorization") String token);
	
	@GetMapping("/dailyshareprice/name/{shareName}")
	public StockDetails finddailyShareByName(@RequestHeader("Authorization") String token,@PathVariable(value="shareName") String shareName);
	
	@GetMapping("/dailyshareprice/{shareIdList}")
	public List<Double> finddailyShareById(@RequestHeader("Authorization") String token,@PathVariable(value="shareIdList")List<String> shareIdList);
}

