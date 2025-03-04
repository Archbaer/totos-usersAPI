//package com.usersapi.usersAPI.controller;
//
//import com.usersapi.usersAPI.model.ProductRequest;
//import com.usersapi.usersAPI.model.ProductResponse;
//import com.usersapi.usersAPI.service.AdminProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/admin/products")
//public class AdminProductController {
//
//    private final AdminProductService productService;
//
//    @Autowired
//    public AdminProductController(AdminProductService productService) {
//        this.productService = productService;
//    }
//
//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
//        ProductResponse response = productService.createProduct(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }
//
//}
