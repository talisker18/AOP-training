package main_package;

/*
 * be careful, do not use too much aspects. dont export business logic to aspects, only decorate business logic
 * 
 * good use case: logging, e.g. what are the params of an executed method? -> log it with aspects
 * 
 * */

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import services.HelloService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
			HelloService service = c.getBean(HelloService.class);
			//service.hello("john");
			
			String result = service.goodMorning("joel");
			System.out.println(result);
			
			
		}

	}

}
