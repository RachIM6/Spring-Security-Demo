package com.spring_security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/user/info")
    public String getUserInfo(Authentication authentication) {
        return "User: " + authentication.getName() + " - Roles: " + authentication.getAuthorities();
    }
}