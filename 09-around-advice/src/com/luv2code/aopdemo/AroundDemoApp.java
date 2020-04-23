package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService service = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("Main Program: AroundemoApp");

		System.out.println("Calling getFortune");
		String data = service.getFortune();
		System.out.println("My fortune is " + data);
		
		System.out.println("Calling method1");
		service.method1();
		
		System.out.println("Finished");

		// close the context
		context.close();
	}

}
