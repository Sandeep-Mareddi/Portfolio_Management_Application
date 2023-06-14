package com.cognizant.calculateNetworth.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.calculateNetworth.controller.StocksContoller;

import com.cognizant.calculateNetworth.*;

@AutoConfigureMockMvc
@SpringBootTest
class CalculateNetworthControllerTest {
	@Autowired
	private StocksContoller controller;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

	@Test
	void main() {
		CalculateNetworthApplication.main(new String[] {});
	}

	@Test
	public void testGetAllMutualFunds() throws Exception {
		ResultActions actions = mvc.perform(get("/NetWorth/mutualfunds"));

	}

	@Test
	public void testGetStcokName() throws Exception {
		ResultActions actions = mvc.perform(get("/NetWorth/pershare/Amazon"));

	}

	@Test
	public void testGetAllStocks() throws Exception {
		ResultActions actions = mvc.perform(get("/NetWorth/shares"));

	}
}
