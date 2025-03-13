package com.usersapi.usersAPI.client;

import com.usersapi.usersAPI.model.ProductRequest;
import com.usersapi.usersAPI.model.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "products-api", url = "http://localhost:8083")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductResponse> getAllProducts();

    @PostMapping("/products")
    ProductResponse addProduct(@RequestBody ProductRequest request);

    @GetMapping("/products/{id}")
    ProductResponse getProduct(@PathVariable("id") Long id);

    @PutMapping("/products/{id}")
    ProductResponse updateProduct(@PathVariable("id") Long id, @RequestBody ProductRequest request);

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable("id") Long id);

}
