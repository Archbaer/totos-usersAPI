package com.usersapi.usersAPI.controller;

import com.usersapi.usersAPI.service.PublicKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PublicKeyService publicKeyService;

    @GetMapping("/test")
    public ResponseEntity<?> testEndpoint() throws Exception {
        PublicKey publicKey = publicKeyService.getPublicKey();
        return ResponseEntity.ok("Public key: " + publicKey.getEncoded());
    }

}
