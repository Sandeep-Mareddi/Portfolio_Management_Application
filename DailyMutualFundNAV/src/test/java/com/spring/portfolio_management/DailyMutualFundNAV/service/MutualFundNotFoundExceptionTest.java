package com.cognizant.portfolio_management.DailyMutualFundNAV.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.portfolio_management.DailyMutualFundNAV.exception.MutualFundNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class MutualFundNotFoundExceptionTest {

	@Test
	void testException() {
		MutualFundNotFoundException exception=new MutualFundNotFoundException("Mutual Fund Not Found Exception");
		assertEquals("Mutual Fund Not Found Exception", exception.getMessage());

	}
}
