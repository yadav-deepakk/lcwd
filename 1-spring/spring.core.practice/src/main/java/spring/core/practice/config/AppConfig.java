package spring.core.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.practice.components.HardDrive;
import spring.core.practice.components.Laptop;

@Configuration
public class AppConfig {

	@Bean
	public HardDrive seagate512() {
		return new HardDrive("Seagate", 512L);
	}

	@Bean
	public HardDrive seagate1024() {
		return new HardDrive("Seagate", 512L);
	}

	@Bean
	public Laptop ideapad320(HardDrive seagate512) {
		return new Laptop("Lenovo Ideapad 320", seagate512);
	}

	@Bean
	public Laptop ideapad330(HardDrive seagate1024) {
		return new Laptop("Lenovo Ideapad 330", seagate1024);
	}

}
