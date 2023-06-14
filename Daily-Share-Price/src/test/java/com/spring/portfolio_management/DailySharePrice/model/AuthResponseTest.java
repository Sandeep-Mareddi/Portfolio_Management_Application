package com.cognizant.portfolio_management.DailySharePrice.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class AuthResponseTest {
	AuthResponse authResponse = new AuthResponse();

	@Test
	void testUid() {
		authResponse.setUid("101");
		assertEquals("101", authResponse.getUid());
	}

	@Test
	void testUname() {
		authResponse.setName("101");
		assertEquals("101", authResponse.getName());
	}

	@Test
	void testIsvalid() {
		authResponse.setValid(true);
		assertEquals(true, authResponse.isValid());
	}
}
