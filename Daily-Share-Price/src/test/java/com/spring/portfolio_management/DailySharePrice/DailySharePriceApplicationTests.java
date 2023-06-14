package com.cognizant.portfolio_management.DailySharePrice;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.portfolio_management.DailySharePrice.controller.ShareDetailsController;

@AutoConfigureMockMvc
@SpringBootTest
class DailySharePriceApplicationTests {

	@Autowired
	private ShareDetailsController shareDetailsController;

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
		assertNotNull(shareDetailsController);
	}

	@Test
	public void testGetDailySharePrice() throws Exception {
		ResultActions actions = mvc.perform(get("/dailyshareprice/name/Amazon"));

	}

	@Test
	public void testGetAllDailySharePrice() throws Exception {
		ResultActions actions = mvc.perform(get("/dailyallshareprice"));

	}

	@Test
	public void testGetDailySharePriceByIDList() throws Exception {
		ResultActions actions = mvc.perform(get("/dailyshareprice/AMZ"));

	}

}
