//package com.usersapi.usersAPI.service;
//
//import com.usersapi.usersAPI.client.ProductClient;
//import com.usersapi.usersAPI.model.ProductRequest;
//import com.usersapi.usersAPI.model.ProductResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminProductService {
//
//    @Autowired
//    private final ProductClient productClient;
//
//    public AdminProductService(ProductClient productClient) {
//        this.productClient = productClient;
//    }
//
//    public ProductResponse createProduct(ProductRequest productRequest) {
//        // Pre-processing logic here
//
//        return productClient.addProduct(productRequest);
//    }
//
//    public ProductResponse getProduct(String id) {
//        return productClient.getProduct(id);
//    }
//
//    public ProductResponse updateProduct(String id, ProductRequest productRequest) {
//        return productClient.updateProduct(id, productRequest);
//    }
//
//    public boolean deleteProduct(String id) {
//        return productClient.deleteProduct(id);
//    }
//}
