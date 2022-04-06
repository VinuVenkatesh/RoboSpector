package com.robospector.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfig {

	@Bean
	public FilterRegistrationBean<JWTAuthTokenFilter> getFilterRegistrationBean() {
		
		FilterRegistrationBean<JWTAuthTokenFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new JWTAuthTokenFilter());
		filterRegistrationBean.addUrlPatterns("/dashboard/*");
		return filterRegistrationBean;
	}
}
