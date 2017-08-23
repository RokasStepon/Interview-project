package com.services.boot;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldServiceTest extends LbgApplicationTests {
	@Autowired
	private HelloWorldService service;
	
	@Before
	void setUp() {
		//tests before initialization
	}
	
	@After
	void tearDown() {
		//tests after initialization
	}
	
	@Test
	public void testSetHello() {
		service.setHello("helloworld", "Hello World !");
		HelloWorld h1 = service.getHello("helloworld");
		
		service.setHello("helloworld", "Hello World !");
		HelloWorld h2 = service.getHello("helloworld");
		
		Assert.assertNotNull("failure - expected not null.", h1);
		Assert.assertNotSame("failure - expected different values", h2, h1);
	}
}
