package com.tuto.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
	public void configure (WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/**");
	}
}
