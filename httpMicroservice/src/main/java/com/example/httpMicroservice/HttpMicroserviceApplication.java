package com.example.httpMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HttpMicroserviceApplication {

	@Autowired
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(HttpMicroserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public void registerCompany() {
		RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);

		String companyName = "goMart";
		String clientID = "37bb493c-73d3-47ea-8675-21f66ef9b735";
		String clientSecret = "HVIQBVbqmTGEmaED";
		String ownerName = "Rahul";
		String ownerEmail = "rahul@abc.edu";
		String rollNo = "1";

		RegistrationRequest registrationRequest = new RegistrationRequest(companyName, clientID, clientSecret, ownerName, ownerEmail, rollNo);

		ResponseEntity<String> registrationResponse = restTemplate.postForEntity("http://20.244.56.144/test/register", registrationRequest, String.class);

		if (registrationResponse.getStatusCode() == HttpStatus.OK) {
			System.out.println("Company registered successfully");
			obtainAuthorizationToken(companyName, clientID, clientSecret, ownerName, ownerEmail, rollNo);
		} else {
			System.err.println("Failed to register company. Please try again later.");
		}
	}

	public void obtainAuthorizationToken(String companyName, String clientID, String clientSecret, String ownerName, String ownerEmail, String rollNo) {
		RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);

		AuthorizationRequest authorizationRequest = new AuthorizationRequest(companyName, clientID, clientSecret, ownerName, ownerEmail, rollNo);

		ResponseEntity<AuthorizationResponse> authorizationResponse = restTemplate.postForEntity("http://20.244.56.144/test/auth", authorizationRequest, AuthorizationResponse.class);

		if (authorizationResponse.getStatusCode() == HttpStatus.OK) {
			AuthorizationResponse body = authorizationResponse.getBody();
			if (body != null) {
				String accessToken = body.getAccessToken();
				System.out.println("Authorization token obtained: " + accessToken);
			} else {
				System.err.println("Failed to obtain authorization token. Response body is empty.");
			}
		} else {
			System.err.println("Failed to obtain authorization token. Status code: " + authorizationResponse.getStatusCodeValue());
		}
	}
}