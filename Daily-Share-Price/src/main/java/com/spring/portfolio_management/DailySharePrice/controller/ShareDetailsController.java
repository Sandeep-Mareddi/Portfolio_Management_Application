package com.cognizant.portfolio_management.DailySharePrice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.portfolio_management.DailySharePrice.model.ShareDetails;
import com.cognizant.portfolio_management.DailySharePrice.service.ShareDetailsService;

@RestController
@CrossOrigin("http://localhost:4200")
public class ShareDetailsController {

	@Autowired
	private ShareDetailsService shareDetailsService;

	@GetMapping("/dailyallshareprice")
	public List<ShareDetails> getAllDailySharePrice(@RequestHeader("Authorization") String token) {
		if (shareDetailsService.isSessionValid(token)) {
			return shareDetailsService.getAllShares();
		}
		return null;
	}

	@GetMapping("/dailyshareprice/name/{shareName}")
	public ShareDetails getDailySharePrice(@RequestHeader("Authorization") String token,
			@PathVariable String shareName) {
		if (shareDetailsService.isSessionValid(token)) {
			return shareDetailsService.getSharebyName(shareName);
		}
		return null;
	}

	@GetMapping("/dailyshareprice/{shareId}")
	public List<Double> getDailySharePriceByIDList(@RequestHeader("Authorization") String token,
			@PathVariable(value = "shareId") List<String> shareId) {
		if (shareDetailsService.isSessionValid(token)) {
			return shareDetailsService.getSharebyIdList(shareId);
		}
		return null;
	}

}
