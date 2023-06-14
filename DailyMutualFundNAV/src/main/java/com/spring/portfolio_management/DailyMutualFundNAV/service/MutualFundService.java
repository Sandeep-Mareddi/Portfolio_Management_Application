package com.cognizant.portfolio_management.DailyMutualFundNAV.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.portfolio_management.DailyMutualFundNAV.controller.AuthClient;
import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.AuthResponse;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.repository.MutualFundRepository;

@Service
public class MutualFundService {

	@Autowired
	private MutualFundRepository mutualFundRepository;

	@Autowired
	private AuthClient authClient;

	@Transactional
	public List<MutualFund> getAllMutualFund() {
		return mutualFundRepository.findAll();
	}

	@Transactional
	public MutualFund getMutualFundByName(String mutualFundName) throws MutualFundNotFoundException {
		if (mutualFundRepository.findByMutualFundName(mutualFundName) == null)
			throw new MutualFundNotFoundException("Mutual Fund Not Found");
		return mutualFundRepository.findByMutualFundName(mutualFundName);
	}

	public List<Double> getMutualFundByIdList(List<String> mutualFundIdList) {
		List<Double> mfValueList = new ArrayList<>();
		List<MutualFund> mfList = mutualFundRepository.findByMutualFundId(mutualFundIdList);
		for (MutualFund m : mfList) {
			mfValueList.add(m.getMutualFundValue());
		}
		return mfValueList;
	}

	public Boolean isSessionValid(String token) {
		AuthResponse authResponse = authClient.getValidity(token);
		if (authResponse == null)
			throw new RuntimeException("Exception Thrown-Null Auth Response returned");

		return true;
	}

}
