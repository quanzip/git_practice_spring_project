package com.api;

import java.sql.PreparedStatement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MyApi {
	public static void main(String []args) {
		final ApplicationContext context = SpringApplication.run(MyApi.class,args);
		Implement imple= context.getBean(Implement.class);
		imple.go();
		
	}
}

interface Animal{
	void go();
}

@Component("dog")
class Dog implements Animal{
	
	
	@Override
	public void go() {
		System.out.print("This is a Dog");
	}
	
	
//	public Dog(@Qualifier(value ="Dog") Animal ani) {
//		this.animal = ani;
//	}
	
	@PostConstruct
	public void postCOnstruct() {
		System.out.println("this method is called after main constructor is called");
	}
	
	@PreDestroy
	public void beforeDestroy() {
		System.out.println("This function is call before being destroyed from this  object");
	}
}

@Component("cat")
class Cat implements Animal{
	
//
	
	@Override
	public void go(){
		System.out.println("Cat are moving");
	}
}

@Component
class Implement{
	
	@Qualifier(value ="dog")
	@Autowired(required = true)
	Animal animal;
	
	public void go() {
		animal.go();
	}
}





