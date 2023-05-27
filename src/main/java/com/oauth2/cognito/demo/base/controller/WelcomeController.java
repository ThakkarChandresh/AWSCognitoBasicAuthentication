package com.oauth2.cognito.demo.base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public ResponseEntity<String> home(Authentication authentication) {
        boolean isAuthenticated = authentication.isAuthenticated();

        ResponseEntity<String> entity;
        if (isAuthenticated) {
            DefaultOidcUser defaultOidcUser = (DefaultOidcUser) authentication.getPrincipal();
            Map<String, Object> userAttributes = defaultOidcUser.getAttributes();

            entity = new ResponseEntity<>("Welcome Dear " + userAttributes.get("cognito:username") + " You Are Authenticated!", HttpStatus.OK);
        } else {
            entity = new ResponseEntity<>("Not Authenticated!", HttpStatus.UNAUTHORIZED);
        }
        return entity;
    }
}
