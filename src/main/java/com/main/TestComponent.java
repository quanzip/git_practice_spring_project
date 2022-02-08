package com.main;

import org.springframework.stereotype.Component;

@Component
public class TestComponent {
	public TestComponent() {
		System.out.println("Hello spring system");
	}

	public void showName() {
		System.out.println(this.getClass() + "Hello quanzip");
	}
}
