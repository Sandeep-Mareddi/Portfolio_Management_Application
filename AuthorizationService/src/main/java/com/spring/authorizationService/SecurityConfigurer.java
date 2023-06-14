package com.cognizant.authorizationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.cognizant.authorizationService.service.AdminDetailsService;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	private static Logger logger = LoggerFactory.getLogger(SecurityConfigurer.class);

	@Autowired
	AdminDetailsService pmsuserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("STARING AUTH SECURITY CONFIGURE");
		super.configure(auth);
		auth.userDetailsService(pmsuserDetailsService);
		logger.info("END AUTH SECURITY CONFIGURE AUTH");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("STARING HTTP SECURITY CONFIGURE");
		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
				.exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		logger.info("ENDDING HTTP SECURITY CONFIGURE");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		logger.info("STARTING WEB SECURITY");

		web.ignoring().antMatchers("/authapp/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui",
				"/configuration/security", "/webjars/**");
		logger.info("ENDING WEB SECURITY");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
