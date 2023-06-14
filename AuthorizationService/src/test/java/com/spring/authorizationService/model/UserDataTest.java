package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.model.UserData;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDataTest {

	UserData userData=new UserData();
	@Test
	public void testUserId()throws Exception
	{
		userData.setUserid("101");
		assertEquals("101",userData.getUserid());
		
	}
	
	@Test
	public void testUserName()throws Exception
	{
		userData.setUname("101");
		assertEquals("101",userData.getUname());
		
	}
	@Test
	public void testToString() {
		UserData user=new UserData("101","pwd","101","101");
		assertEquals("UserData [userid=null, upassword=null, uname=null, authtoken=null]",userData.toString());
	}

}