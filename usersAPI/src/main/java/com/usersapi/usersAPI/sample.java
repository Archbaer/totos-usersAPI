//package com.usersapi.usersAPI;
//
//import feign.RequestInterceptor;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//public class sample {
//
//    // In users-api
//
//    // 1. Data Transfer Objects
//    public class ProductRequest {
//        private String name;
//        private String description;
//        private BigDecimal price;
//        private Integer stockQuantity;
//
//        // Getters, setters, constructors
//    }
//
//    public class ProductResponse {
//        private String id;
//        private String name;
//        private String description;
//        private BigDecimal price;
//        private Integer stockQuantity;
//        private LocalDateTime createdAt;
//
//        // Getters, setters, constructors
//    }
//
//    // 2. FeignClient Interface
//    @FeignClient(name = "products-api", url = "${products.api.url}")
//    public interface ProductClient {
//        @PostMapping("/api/products")
//        ProductResponse addProduct(@RequestBody ProductRequest request);
//
//        @GetMapping("/api/products/{id}")
//        ProductResponse getProduct(@PathVariable("id") String id);
//
//        @PutMapping("/api/products/{id}")
//        ProductResponse updateProduct(@PathVariable("id") String id, @RequestBody ProductRequest request);
//
//        @DeleteMapping("/api/products/{id}")
//        void deleteProduct(@PathVariable("id") String id);
//    }
//
//    // 3. Configuration to propagate JWT token
//    @Configuration
//    public class FeignClientConfig {
//        @Bean
//        public RequestInterceptor requestInterceptor() {
//            return requestTemplate -> {
//                ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//                if (attributes != null) {
//                    HttpServletRequest request = attributes.getRequest();
//                    String authHeader = request.getHeader("Authorization");
//                    if (authHeader != null) {
//                        requestTemplate.header("Authorization", authHeader);
//                    }
//                }
//            };
//        }
//    }
//
//    // 4. Service Layer
//    @Service
//    public class AdminProductService {
//        private final ProductClient productClient;
//
//        @Autowired
//        public AdminProductService(ProductClient productClient) {
//            this.productClient = productClient;
//        }
//
//        public ProductResponse createProduct(ProductRequest productRequest) {
//            // You can add pre-processing logic here if needed
//            return productClient.addProduct(productRequest);
//        }
//
//        public ProductResponse getProduct(String id) {
//            return productClient.getProduct(id);
//        }
//
//        public ProductResponse updateProduct(String id, ProductRequest productRequest) {
//            return productClient.updateProduct(id, productRequest);
//        }
//
//        public void deleteProduct(String id) {
//            productClient.deleteProduct(id);
//        }
//    }
//
//    // 5. Controller
//    @RestController
//    @RequestMapping("/admin/products")
//    public class AdminProductController {
//        private final AdminProductService productService;
//
//        @Autowired
//        public AdminProductController(AdminProductService productService) {
//            this.productService = productService;
//        }
//
//        @PostMapping
//        @PreAuthorize("hasRole('ADMIN')")
//        public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
//            ProductResponse response = productService.createProduct(request);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        }
//
//        @GetMapping("/{id}")
//        @PreAuthorize("hasRole('ADMIN')")
//        public ResponseEntity<ProductResponse> getProduct(@PathVariable String id) {
//            ProductResponse response = productService.getProduct(id);
//            return ResponseEntity.ok(response);
//        }
//
//        @PutMapping("/{id}")
//        @PreAuthorize("hasRole('ADMIN')")
//        public ResponseEntity<ProductResponse> updateProduct(
//                @PathVariable String id,
//                @RequestBody ProductRequest request) {
//            ProductResponse response = productService.updateProduct(id, request);
//            return ResponseEntity.ok(response);
//        }
//
//        @DeleteMapping("/{id}")
//        @PreAuthorize("hasRole('ADMIN')")
//        public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
//            productService.deleteProduct(id);
//            return ResponseEntity.noContent().build();
//        }
//    }
//
//// 6. Application properties (application.yml)
//// products:
////   api:
////     url: http://localhost:8082
//}
