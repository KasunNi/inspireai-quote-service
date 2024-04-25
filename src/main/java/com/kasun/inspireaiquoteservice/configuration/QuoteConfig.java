package com.kasun.inspireaiquoteservice.configuration;

import com.kasun.inspireaiquoteservice.service.QuoteService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuoteConfig {

	@Bean
	public QuoteService userBean() {
		return new QuoteService();
	}

	@Bean
	public ModelMapper modelMapperBean() {
		return new ModelMapper();
	}

}
