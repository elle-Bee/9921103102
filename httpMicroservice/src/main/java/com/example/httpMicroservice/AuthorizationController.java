package com.example.httpMicroservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthorizationController {

    private static final String AUTHORIZATION_URL = "http://20.244.56.144/test/auth";

    @PostMapping("/authorize")
    public ResponseEntity<String> authorizeCompany(@RequestBody AuthorizationRequest authorizationRequest) {
        // Send POST request to obtain authorization token
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(AUTHORIZATION_URL, authorizationRequest, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}