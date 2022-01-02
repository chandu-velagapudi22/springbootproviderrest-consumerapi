package com.example.demo.resttem;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

//@RestController
public class ConsumerController {

	@GetMapping("/con")
	public ResponseEntity<?> myConsumer() {
		System.out.println("I am in my consumer ()");

		// Creating resttemplet object

		RestTemplate restTemplate = new RestTemplate();

		// Creating endpoint url to axcess the producer data

		String endpoint = "http://localhost:9635/dwm/{name}/{id}";
		// Generate Http request with get mode to consume the webservice
		ResponseEntity<String> forEntity = restTemplate.getForEntity(endpoint, String.class,"chandu",100);
		System.out.println("***********");
		System.out.println(forEntity.getBody());
		System.out.println(forEntity.getClass());
		System.out.println(forEntity.getStatusCode());
		System.out.println("***********");
		return new ResponseEntity<String>("welcome to consemer" + forEntity, HttpStatus.CREATED);
	}
}
