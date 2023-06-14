package com.cognizant.authorizationService.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthResponseTest {
	
	AuthResponse authResponse=new AuthResponse();
	
	@Test
	public void testUid() throws Exception

	{
		authResponse.setUid("101");
		assertEquals("101",authResponse.getUid());
	}
	@Test
	public void testUname() throws Exception

	{
		authResponse.setName("101");
		assertEquals("101",authResponse.getName());
	}
	@Test
	public void testIsValid() throws Exception

	{
		
		authResponse.setValid(true);
		assertEquals(true,authResponse.isValid());
	}
}
