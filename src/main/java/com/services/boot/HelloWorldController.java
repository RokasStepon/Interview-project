package com.services.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	HelloWorldService service;
	
    @RequestMapping(value="/helloworld", method=RequestMethod.GET, produces = "application/json")
    public @ResponseBody HelloWorld sayHelloWorld() {
    	service.setHello("helloworld", "Hello World !");
        return service.getHello("helloworld");
    }
    
    @RequestMapping(value="/hello", method=RequestMethod.POST, produces = "application/json")
    public @ResponseBody HelloWorld sayHello(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        service.setHello("hello", String.format("Hello %s !", name));
    	return service.getHello("hello");
    }
    
    @RequestMapping(value="/hellokitty", method=RequestMethod.GET)
    public String sayHelloKitty() {
    	return "<img src='https://cdn.shopify.com/s/files/1/0770/2163/t/2/assets/character_img_1.jpg?10315697347078629510' />";
    }
    
}
