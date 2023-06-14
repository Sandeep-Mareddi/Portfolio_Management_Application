package com.cognizant.portfolio_management.DailyMutualFundNAV.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.portfolio_management.DailyMutualFundNAV.model.AuthResponse;
import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;
import com.cognizant.portfolio_management.DailyMutualFundNAV.service.MutualFundService;

@SpringBootTest
@AutoConfigureMockMvc
class MutualFundControllerTest {

	@Mock
	MutualFundService service;

	@Autowired
	MutualFundController controller;
	@Autowired
	MockMvc mockMvc;

	@Mock
	AuthClient authClient;

	@Test
	void testgetAllMutualFund() throws Exception {
		String token = new String("token");
		AuthResponse authResponse = new AuthResponse();
		authResponse.setUid("1001");
		authResponse.setName("Name");
		authResponse.setValid(true);
		when(authClient.getValidity(token)).thenReturn(authResponse);
		when(service.isSessionValid(token)).thenReturn(true);

		List<MutualFund> fundList = new ArrayList<>();
		fundList.add(new MutualFund("1001", "FundName1", 50000.0));
		fundList.add(new MutualFund("1002", "FundName2", 60000.0));
		when(authClient.getValidity("token")).thenReturn(authResponse);
		when(service.isSessionValid("token")).thenReturn(true);
		when(service.getAllMutualFund()).thenReturn(fundList);
		assertTrue(service.isSessionValid(token));

		assertEquals(fundList, controller.getAllMutualFund(token));
	}

	@Test
	void testgetAllMutualFundNull() throws Exception {
		String token = null;
		AuthResponse authResponse = null;

		List<MutualFund> fundList = null;

		when(authClient.getValidity("token")).thenReturn(authResponse);
		when(service.isSessionValid("token")).thenReturn(false);
		when(service.getAllMutualFund()).thenReturn(fundList);
		assertFalse(service.isSessionValid(token));
		assertNull(controller.getAllMutualFund(token));
	}

	@Test
	void testGetDailyMutualFundNav() {

	}

	@Test
	void testGetDailyMutualFundNavNegative() {

	}
}
