package com.cognizant.calculateNetworth.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
//import static org.mockito.Mockito.when;  
import static org.mockito.Mockito.*;

import com.cognizant.calculateNetworth.controller.AuthClient;
import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.reposotory.AssetRepository;

@RunWith(MockitoJUnitRunner.class)
class SellAssetServiceTest {

	@Mock
	AssetRepository repository;

	@Mock
	AuthClient authClient;

	@InjectMocks
	SellAssetService sellAssetService;

	@Test
	void testDeleteMutualFundAssetWithUnits() {
	}

	private static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDEiLCJpYXQiOjE2MjkxOTQxMjd9.MqXpGGoPGO4gF_kGNR81NnnBZglmQOUWuRBT0CjZQoQ";

}
