package com.batch.lcwd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.batch.lcwd.components.Employee;


@SpringBootApplication
public class SpringCoreConceptsApplication {

	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringCoreConceptsApplication.class, args);

//		Car c = ctx.getBean(Car.class);
//		System.out.println(c);

//		WebPageController controller = ctx.getBean(WebPageController.class); 
//		controller.login(); 

//		Engine e1 = ctx.getBean(Engine.class); 
//		Engine e2 = ctx.getBean(Engine.class); 
//		Engine e3 = ctx.getBean(Engine.class); 
//		
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(e3);
//		
//		if(e1 == e2 && e2 == e3) {
//			System.out.println("Same bean is given by context everytime.");
//		}

//		WindShield w1 = ctx.getBean(WindShield.class);
//		WindShield w2 = ctx.getBean(WindShield.class);
//		WindShield w3 = ctx.getBean(WindShield.class);
//
//		System.out.println(w1);
//		System.out.println(w2);
//		System.out.println(w3);
//
//		if (w1 == w2 && w2 == w3) {
//			System.out.println("same bean is given by context everytime.");
//		} else {
//			System.out.println("bean is given by context is different than previous.");
//		}
		
		Employee emp = ctx.getBean(Employee.class); 
		emp.markIn();
		emp.doWork();
		emp.markOut();
		ctx.close();

	}

}
