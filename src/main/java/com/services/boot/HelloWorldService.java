package com.services.boot;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

// hello world service which sets and returns message
// it uses endpoints as ID
@Service
public class HelloWorldService {
	Hashtable<String, HelloWorld> messages = new Hashtable<String, HelloWorld>();
	
	public HelloWorldService() {
	}
	
	void setHello(String endpoint, String message) {
		HelloWorld result = new HelloWorld();
		result.setMessage(message);
		messages.put(endpoint, result);
	}
	
	public HelloWorld getHello(String endpoint) {
		if (messages.containsKey(endpoint)) {
			return messages.get(endpoint);
		}
		return null;
	}
}
