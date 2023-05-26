package com.oauth2.cognito.demo.base.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public ResponseEntity<String> home(Principal principal) {

        return new ResponseEntity<>("Welcome Dear You Are Authenticated!" + principal.getName(), HttpStatus.OK);

    }
}
