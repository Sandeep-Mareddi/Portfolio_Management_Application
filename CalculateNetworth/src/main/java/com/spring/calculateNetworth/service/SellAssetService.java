package com.cognizant.calculateNetworth.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.controller.AuthClient;
import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.AuthResponse;
import com.cognizant.calculateNetworth.reposotory.AssetRepository;
@Service
public class SellAssetService {
	
	@Autowired
	private AssetRepository assetRepository;
	
	@Autowired
	private AuthClient authClient;
	
	public void deleteStockAssetWithUnits(int portfolioId,Map<String,Integer> idList) {
		for(String id:idList.keySet()) {
		Asset a = assetRepository.findByPortfolioidAndAssetidAndType(portfolioId,id,"Share");
		int units=a.getUnits()-idList.get(id);
		if(units>0) {
			a.setUnits(units);
			assetRepository.save(a);
		}
		else {
			assetRepository.delete(a);
		}
		}
	}
	
	public void deleteMutualFundAssetWithUnits(int portfolioId,Map<String, Integer> mfIdList) {
		for(String id:mfIdList.keySet()) {
			Asset a = assetRepository.findByPortfolioidAndAssetidAndType(portfolioId,id,"MF");
			int units=a.getUnits()-mfIdList.get(id);
			if(units>0) {
				a.setUnits(units);
				assetRepository.save(a);
			}
			else {
				assetRepository.delete(a);
			}
			}
	}
	
	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
	

}
