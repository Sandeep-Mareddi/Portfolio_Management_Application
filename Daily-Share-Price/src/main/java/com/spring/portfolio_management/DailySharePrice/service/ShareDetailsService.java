package com.cognizant.portfolio_management.DailySharePrice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.portfolio_management.DailySharePrice.controller.AuthClient;
import com.cognizant.portfolio_management.DailySharePrice.model.AuthResponse;
import com.cognizant.portfolio_management.DailySharePrice.model.ShareDetails;
import com.cognizant.portfolio_management.DailySharePrice.respository.ShareRepository;

@Service
public class ShareDetailsService {

	@Autowired
	private ShareRepository shareRepository;

	@Autowired
	private AuthClient authClient;

	@Transactional
	public List<ShareDetails> getAllShares() {
		return shareRepository.findAll();
	}

	@Transactional
	public ShareDetails getSharebyName(String shareName) {
		return shareRepository.findByShareName(shareName);
	}

	public List<Double> getSharebyIdList(List<String> shareId) {
		List<Double> shareValueList = new ArrayList<>();
		List<ShareDetails> shareList = shareRepository.findByShareId(shareId);
		for (ShareDetails s : shareList) {
			shareValueList.add(s.getShareValue());
		}
		return shareValueList;
	}

	public Boolean isSessionValid(String token) {
		try {
			@SuppressWarnings("unused")
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
