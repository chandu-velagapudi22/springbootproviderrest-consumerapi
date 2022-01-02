package com.example.demo.resttem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ConsumerControllerUsingExchange implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I am in the ConsumerControllerUsingExchange class");

		// Creating object for the restTemplet
		RestTemplate restTemplate = new RestTemplate();
		// Creating the endpoint url
		String endpoint = "http://localhost:9635/wel";
		// use the exchange method for axcess the data
		ResponseEntity<String> exchange = restTemplate.exchange(endpoint, HttpMethod.GET, null, String.class);
		// Getting the output
		System.out.println("***************");
		System.out.println("I am using fetBody()");
		System.out.println(exchange.getBody());
		System.out.println("***************");
		System.out.println("I am checking statscode()");
		System.out.println(exchange.getStatusCode());
		System.out.println("***************");
		System.out.println("I am checking the class");
		System.out.println(exchange.getClass());
		System.out.println("***************");
	}

}
