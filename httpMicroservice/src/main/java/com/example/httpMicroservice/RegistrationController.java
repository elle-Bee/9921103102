package com.example.httpMicroservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RegistrationController {

    private static final String TEST_SERVER_REGISTER_URL = "http://20.244.56.144/test/register";
    private static final String ACCESS_CODE = "FKDLjg";

    @PostMapping("/register")
    public ResponseEntity<String> registerCompany(@RequestBody RegistrationService registrationDetails) {
        RegistrationService request = new RegistrationService(
                registrationDetails.getCompanyName(),
                registrationDetails.getOwnerName(),
                registrationDetails.getRollNo(),
                registrationDetails.getOwnerEmail(),
                ACCESS_CODE
        );

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(TEST_SERVER_REGISTER_URL, request, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Company registered successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to register company. Please try again later.");
        }
    }
}