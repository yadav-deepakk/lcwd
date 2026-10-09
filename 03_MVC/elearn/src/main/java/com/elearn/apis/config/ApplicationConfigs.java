package com.elearn.apis.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigs {

	@Bean
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
