package com.example.demo.resttem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.javadata.ActorData;
import com.fasterxml.jackson.databind.ObjectMapper;

//@Component
public class ConsumerController_GettingJsonData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("*********************");
		System.out.println("I am inside the ConsumerController_GettingJsonData()");
		System.out.println("*********************");
		// Creating object for the RestTemplet
		RestTemplate restTemplate = new RestTemplate();
		// Defing the producer endpoint
		String endPoint = "http://localhost:9635/find/10";
		// invoking the producer ()
		ResponseEntity<String> exchange = restTemplate.exchange(endPoint, HttpMethod.GET, null, String.class);
		System.out.println(exchange.getBody());
		System.out.println(exchange.getHeaders());
		System.out.println(exchange.getClass());
		// Actvalluy i got the json data i am converting into javaObject
		String body = exchange.getBody();
		// create object mapper
		ObjectMapper objectMapper = new ObjectMapper();
		// object mapper to convert Json to JavaObject
		ActorData readValue = objectMapper.readValue(body, ActorData.class);
		// Print the data
		System.out.println("Chandu chowdary please cheack the data");
		System.out.println(readValue);
		// ______________________________________________________
		/**
		 * Here i am converting java to json and i am converting json to java
		 */
			}

}
