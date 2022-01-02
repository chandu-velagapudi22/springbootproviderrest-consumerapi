package com.example.demo.resttem;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.javadata.ActorData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerController_CovertingBulkData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Creating an object for RestTemplet
		RestTemplate restTemplate2 = new RestTemplate();
		// Creating the endpoint url
		String endpointurl = "http://localhost:9635/findall";
		// getting the data from the producer by using the exchange method
		ResponseEntity<String> exchange2 = restTemplate2.exchange(endpointurl, HttpMethod.GET, null, String.class);
		// printing the jsoin data
		System.out.println("**********************");
		System.out.println("I am printing the json data  in Conumer class");
		System.out.println(exchange2.getBody());
		System.out.println(exchange2.getHeaders());
		System.out.println(exchange2.getClass());
		System.out.println("***********************");
		// I am converting json to java
		String body2 = exchange2.getBody();
		// Creating an object for objectmapper
		ObjectMapper objectMapper2 = new ObjectMapper();
		// converting json to java
		ActorData[] readValue2 = objectMapper2.readValue(body2, ActorData[].class);
		// Printing java data to object
		System.out.println(readValue2);
		/**
		 * Converting java to json
		 */
		System.out.println("$$$$$$$$$$$$$$$$$$$");
		List<ActorData> asList = Arrays.asList(readValue2);
		asList.forEach(System.out::println);

	}

}
