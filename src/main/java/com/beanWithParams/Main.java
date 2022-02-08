package com.beanWithParams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@SpringBootApplication
public class Main {
	public static void main(String []args) {
		final ApplicationContext context =
				SpringApplication.run(Main.class);
		final HelloWorld myClass  = context.getBean(HelloWorld.class);
		myClass.go();
		
//		final IMyinterface my = context.getBean(IMyinterface.class);
//		my.go();    => ok
		
//		final HelloWorld helloWorld = context.getBean(HelloWorld.class);
//		helloWorld.go();   => same to below one
//		helloWorld.myInterface.go(); => same to above oneS
		
	}
}

//interface Animal{
//	int getRu
//}

@Repository
class quanzip {
	public quanzip() {
		System.out.println("Hello quanzip");
	}
}

@Component()
class HelloWorld implements IMyinterface{
	
	@Autowired
	IMyinterface myInterface;
	
	private String myPrivateName = "Diglogan";
	
	public HelloWorld(quanzip q) {  // không có class [quanzip] với @repository
									// thì sẽ lối, nhưng nếu trong bean tồn tại 
									// thì spring boot sẽ tự động lấy chúng làm tham số
									// khởi tạo
		myPrivateName = "quan";
		 System.out.println(myPrivateName);
	}

	@Override 
	public void go() {
		System.out.println("Hello World" + this);
	}
	
}

interface IMyinterface{
	void go();
}
