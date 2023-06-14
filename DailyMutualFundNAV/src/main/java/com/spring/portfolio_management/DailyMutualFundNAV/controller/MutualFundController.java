package com.cognizant.portfolio_management.DailyMutualFundNAV.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.service.MutualFundService;

@RestController
@CrossOrigin("http://localhost:4200")
public class MutualFundController {

	@Autowired
	private MutualFundService mutualFundService;

	@GetMapping("/dailyallmutualfundnav")
	public List<MutualFund> getAllMutualFund(@RequestHeader("Authorization") String token) {
		if (mutualFundService.isSessionValid(token)) {
			return mutualFundService.getAllMutualFund();
		}
		return null;
	}

	@GetMapping("/dailymutualfundnav/name/{mutualFundName}")
	public MutualFund getDailyMutualFundNav(@RequestHeader("Authorization") String token,
			@PathVariable String mutualFundName) throws MutualFundNotFoundException {
		if (mutualFundService.isSessionValid(token)) {
			return mutualFundService.getMutualFundByName(mutualFundName);
		}
		return null;
	}

	@GetMapping("/dailymutualfundnav/{mutualFundId}")
	public List<Double> getDailyMutualFundNavById(@RequestHeader("Authorization") String token,
			@PathVariable(value = "mutualFundId") List<String> mutualFundIdList) throws MutualFundNotFoundException {
		if (mutualFundService.isSessionValid(token)) {
			return mutualFundService.getMutualFundByIdList(mutualFundIdList);
		}
		return null;
	}
}
