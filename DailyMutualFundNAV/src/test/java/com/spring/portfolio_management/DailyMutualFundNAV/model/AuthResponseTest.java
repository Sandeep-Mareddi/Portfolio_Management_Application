package com.cognizant.portfolio_management.DailyMutualFundNAV.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.portfolio_management.DailyMutualFundNAV.model.AuthResponse;

@SpringBootTest
@AutoConfigureMockMvc
class AuthResponseTest {

	@Test
	void testSetUid() {
		AuthResponse authResponse = new AuthResponse();
		authResponse.setUid("1001");
		assertEquals(Integer.valueOf(1001), Integer.valueOf(authResponse.getUid()));
	}

	@Test
	void testSetName() {
		AuthResponse authResponse = new AuthResponse();
		authResponse.setName("Mutual");
		assertEquals("Mutual", authResponse.getName());
	}

	@Test
	void testSetValid() {
		AuthResponse authResponse = new AuthResponse();
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}

}
