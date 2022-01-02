package com.example.demo.resttem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class ConsumerControllerForPostMethod implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Creatting object for RestTemplet
		RestTemplate restTemplate = new RestTemplate();
		// Creating the endpoint url
		String endpoint = "http://localhost:9635/save";
		// prepare json data bcz i am using the post() so i want to send here json data
		String json_Data = "{\"actorId\":122,\"actorName\":\"chandu\",\"actorage\":26,\"actorStatus\":\"hero\"}";
		// prepare Headers
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		// prepare HttpRequests as HttpEntityObject having head and body
		HttpEntity<String> httpEntity = new HttpEntity<>(json_Data, httpHeaders);
		// Make HttpRequest call in post mode
		ResponseEntity<String> response = restTemplate.postForEntity(endpoint, httpEntity, String.class);
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
	}

}
