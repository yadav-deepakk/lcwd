package com.batch.lcwd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.batch.lcwd.controller.WebPageController;


@SpringBootApplication
public class SpringCoreConceptsApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringCoreConceptsApplication.class, args);
//		Car c = ctx.getBean(Car.class);
//		System.out.println(c);
		
		WebPageController controller = ctx.getBean(WebPageController.class); 
		controller.login(); 
		ctx.close();

	}

}
