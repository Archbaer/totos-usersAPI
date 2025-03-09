package com.usersapi.usersAPI.service;

import com.usersapi.usersAPI.client.ProductClient;
import com.usersapi.usersAPI.model.ProductRequest;
import com.usersapi.usersAPI.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminProductService {

    @Autowired
    private final ProductClient productClient;

    public AdminProductService(ProductClient productClient) {
        this.productClient = productClient;
    }

    public List<ProductResponse> getAllProducts() {
        return productClient.getAllProducts();
    }

    public ProductResponse createProduct(ProductRequest productRequest) {
        // Pre-processing logic here
        return productClient.addProduct(productRequest);
    }

    public ProductResponse getProduct(Long id) {
        return productClient.getProduct(id);
    }

    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        return productClient.updateProduct(id, productRequest);
    }

    public void deleteProduct(Long id) {
        productClient.deleteProduct(id);
    }
}
