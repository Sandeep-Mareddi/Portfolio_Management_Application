package com.cognizant.portfolio_management.DailyMutualFundNAV.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.type.descriptor.java.ArrayMutabilityPlan;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.portfolio_management.DailyMutualFundNAV.controller.AuthClient;
import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.AuthResponse;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.repository.MutualFundRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class MutualFundServiceTest {

	@InjectMocks
	MutualFundService service;

	@Mock
	MutualFundRepository repository;

	@Mock
	AuthClient authClient;

	@Test
	void testGetAllMutualFund() {
		List<MutualFund> fundList = new ArrayList<>();
		fundList.add(new MutualFund("1001", "FundName1", 50000.0));
		fundList.add(new MutualFund("1002", "FundName2", 60000.0));
		when(repository.findAll()).thenReturn(fundList);
		assertEquals(fundList, service.getAllMutualFund());
	}

	@Test
	void testGetMutualFundByName() throws MutualFundNotFoundException {
		MutualFund mutualFund = new MutualFund("1001", "FundName1", 50000.0);
		when(repository.findByMutualFundName("FundName1")).thenReturn(mutualFund);
		assertEquals("FundName1", service.getMutualFundByName("FundName1").getMutualFundName());
	}

	@Test
	void testGetMutualFundByNameNull() throws MutualFundNotFoundException {
		MutualFund mutualFund = null;
		when(repository.findByMutualFundName("FundName1")).thenReturn(mutualFund);
		assertNull(mutualFund);
	}

	@Test
	void testGetMutualFundByNameException() {
		MutualFund mutualFund = null;
		when(repository.findByMutualFundName("FundName1")).thenReturn(mutualFund);
		try {
			assertEquals(null, service.getMutualFundByName("FundName1"));
		} catch (MutualFundNotFoundException e) {
			assertEquals("Mutual Fund Not Found", e.getMessage());
		}

	}

	@Test
	void testGgetMutualFundByIdList() {
		List<MutualFund> fundList = new ArrayList<>();
		fundList.add(new MutualFund("1001", "FundName1", 50000.0));
		fundList.add(new MutualFund("1002", "FundName2", 60000.0));
		List<String> mutualFundIdList = new ArrayList<>();
		mutualFundIdList.add(fundList.get(0).getMutualFundId());
		mutualFundIdList.add(fundList.get(1).getMutualFundId());
		List<Double> mfValueList = new ArrayList<>();
		mfValueList.add(fundList.get(0).getMutualFundValue());
		mfValueList.add(fundList.get(1).getMutualFundValue());
		when(repository.findByMutualFundId(mutualFundIdList)).thenReturn(fundList);
		assertEquals(mfValueList, service.getMutualFundByIdList(mutualFundIdList));

	}

	@Test
	void testIsSessionValid() {
		String token = new String("token");
		AuthResponse authResponse = new AuthResponse();
		authResponse.setUid("1001");
		authResponse.setName("Name");
		authResponse.setValid(true);
		when(authClient.getValidity(token)).thenReturn(authResponse);
		assertTrue(service.isSessionValid(token));

	}

	@Test
	void testIsSessionValidException() {
		String token = null;
		AuthResponse authResponse = null;
		when(authClient.getValidity(token)).thenReturn(authResponse);
		try {
			service.isSessionValid(token);
		} catch (RuntimeException e) {
			assertEquals("Exception Thrown-Null Auth Response returned", e.getMessage());
		}

	}

}
