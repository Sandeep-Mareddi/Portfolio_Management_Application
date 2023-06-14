package com.cognizant.calculateNetworth.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.calculateNetworth.model.MutualFundDetails;

@FeignClient(name="DailyMutualFundService",url="http://localhost:8090")
public interface MutualFundDetailsFeignProxy {
	
	@GetMapping("/dailyallmutualfundnav")
	public List<MutualFundDetails> getAllMututalFunds(@RequestHeader("Authorization") String token);
	
	@GetMapping("/dailymutualfundnav/name/{mutualFundName}")
	public MutualFundDetails getMutualDetails(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundName") String mutualFundName);
	
	@GetMapping("/dailymutualfundnav/{mutualFundIdList}")
	public List<Double> getMutualDetailsById(@RequestHeader("Authorization") String token,@PathVariable(value="mutualFundIdList") List<String> mutualFundId);

}
