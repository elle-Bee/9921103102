package com.example.httpMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ProductController {

    @Autowired
    priv    ate ProductService productService;

    @GetMapping("/{categoryname}/products")
    public ResponseEntity<List<Product>> getTopProducts(
            @PathVariable String categoryname,
            @RequestParam int n,
            @RequestParam(required = false, defaultValue = "rating") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String sortOrder,
            @RequestParam(required = false, defaultValue = "1") int page
    ) {
        List<Product> products = productService.getTopProducts(categoryname, n, sortBy, sortOrder, page);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{categoryname}/products/{productName}")
    public ResponseEntity<Product> getProductDetails(
            @PathVariable String categoryname,
            @PathVariable String productName
    ) {
        Product product = productService.getProductDetails(categoryname, productid);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
}