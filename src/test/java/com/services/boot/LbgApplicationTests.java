package com.services.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LbgApplicationTests {
	@Autowired
	private HelloWorldService service;
	
	@LocalServerPort
    private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void testSetHello() {
		service.setHello("helloworld", "Hello World !");
		HelloWorld h1 = service.getHello("helloworld");
		
		service.setHello("helloibm", "Hello IBM !");
		HelloWorld h2 = service.getHello("helloibm");
		
		Assert.assertNotNull("failure - expected not null.", h1);
		Assert.assertNotSame("failure - expected different values", h2, h1);
	}
	
	// test if GET return set message
    @Test
    public void helloworldEndpointTest() throws Exception {
    	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/helloworld",
        String.class)).contains("Hello World !");

    }
    
    //test if POST doesnt return null
    @Test
    public void helloEndpointTest() throws Exception {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    	MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
    	map.add("name", "Rokas");
    	HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
    	ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:" + port + "/hello", request , String.class );
    	assertThat(response).isNotNull();
    }
    
    // test if contains image
    @Test
    public void hellokittyEndpointTest() throws Exception {
    	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/hellokitty",
        String.class)).contains("<img src");
    }

}
