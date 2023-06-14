package com.cognizant.portfolio_management.DailyMutualFundNAV.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@SpringBootTest
public class SwaggerUiTest {

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
       assertNotNull(mvc);
   }
    
	@Test
	public void testIndex() throws Exception {
		mvc.perform(get("/")).andExpect(status().is3xxRedirection());		
	}
	
	@Test
	public void testIndexredirectdUrl() throws Exception {
		
		mvc.perform(get("/")).andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("swagger-ui.html"));
			
	}
}
