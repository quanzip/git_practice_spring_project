package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.api.MyApi;

@SpringBootApplication
public class Main {
	public static void main(String []args) {
		final ApplicationContext context =   SpringApplication.run(Main.class, args);
		final TestComponent test = context.getBean(TestComponent.class);
		test.showName();
	}
}
