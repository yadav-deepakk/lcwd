package com.batch.lcwd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.lcwd.components.Wheel;

@Configuration
public class AppConfig {

	@Bean("MRF")
	public Wheel mrf() {
		return new Wheel("MRF");
	}

	@Bean("CEAT")
	public Wheel ceat() {
		return new Wheel("CEAT");
	}
	
	@Bean("BKT")
	public Wheel bkt() {
		return new Wheel("BKT");
	}

}
