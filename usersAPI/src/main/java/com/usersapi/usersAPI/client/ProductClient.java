//package com.usersapi.usersAPI.client;
//
//import com.usersapi.usersAPI.model.ProductRequest;
//import com.usersapi.usersAPI.model.ProductResponse;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.*;
//
//@FeignClient(name = "products-api", url = "")
//public interface ProductClient {
//
//    @PostMapping("/api/products")
//    ProductResponse addProduct(@RequestBody ProductRequest request);
//
//    @GetMapping("/api/products/{id}")
//    ProductResponse getProduct(@PathVariable("id") String id);
//
//    @PutMapping("/api/products/{id}")
//    ProductResponse updateProduct(@PathVariable("id") String id, @RequestBody ProductRequest request);
//
//    @DeleteMapping("/api/products/{id}")
//    boolean deleteProduct(@PathVariable("id") String id);
//
//}
