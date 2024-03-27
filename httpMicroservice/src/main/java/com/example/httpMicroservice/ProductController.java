package com.example.httpMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/companies/{companyName}/categories/{categoryName}/products")
    public ResponseEntity<List<Product>> getProducts(
            @PathVariable String companyName,
            @PathVariable String categoryName,
            @RequestParam int top,
            @RequestParam int minPrice,
            @RequestParam int maxPrice,
            @RequestParam(required = false, defaultValue = "1") int page) {
        List<Product> products = productService.getProducts(companyName, categoryName, top, minPrice, maxPrice, page);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/companies/{companyName}/categories/{categoryName}/products/{productId}")
    public ResponseEntity<Product> getProductDetails(
            @PathVariable String companyName,
            @PathVariable String categoryName,
            @PathVariable String productId) {
        Product product = productService.getProductDetails(companyName, categoryName, productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}