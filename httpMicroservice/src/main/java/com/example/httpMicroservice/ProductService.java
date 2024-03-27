package com.example.httpMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Service
public class ProductService {

    private static final String TEST_SERVER_BASE_URL = "http://20.244.56.144/test/companies/";
    private static final String ACCESS_CODE = "FKDLjg"; // Access code provided

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getProducts(String companyName, String categoryName, int top, int minPrice, int maxPrice, int page) {
        String apiUrl = buildApiUrl(companyName, categoryName, top, minPrice, maxPrice, page);

        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );

        List<Product> products = responseEntity.getBody();
        return products;
    }

    public Product getProductDetails(String companyName, String categoryName, String productId) {
        String apiUrl = TEST_SERVER_BASE_URL + companyName + "/categories/" + categoryName + "/products/" + productId;

        ResponseEntity<Product> responseEntity = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                Product.class
        );

        return responseEntity.getBody();
    }

    private String buildApiUrl(String companyName, String categoryName, int top, int minPrice, int maxPrice, int page) {
        StringBuilder apiUrl = new StringBuilder(TEST_SERVER_BASE_URL);
        apiUrl.append(companyName)
                .append("/categories/")
                .append(categoryName)
                .append("/products?top=")
                .append(top)
                .append("&minPrice=")
                .append(minPrice)
                .append("&maxPrice=")
                .append(maxPrice)
                .append("&page=")
                .append(page);

        return apiUrl.toString();
    }
}