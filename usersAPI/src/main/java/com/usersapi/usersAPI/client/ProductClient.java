package com.usersapi.usersAPI.client;

import com.usersapi.usersAPI.model.ProductRequest;
import com.usersapi.usersAPI.model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "products-api", url = "http://localhost:8082")
public interface ProductClient {

    @GetMapping("/api/products")
    List<ProductResponse> getAllProducts();

    @PostMapping("/api/products")
    ProductResponse addProduct(@RequestBody ProductRequest request);

    @GetMapping("/api/products/{id}")
    ProductResponse getProduct(@PathVariable("id") Long id);

    @PutMapping("/api/products/{id}")
    ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest request);

    @DeleteMapping("/api/products/{id}")
    void deleteProduct(@PathVariable("id") Long id);

}
