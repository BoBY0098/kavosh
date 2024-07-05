package com.example.kavosh.controller;

import com.example.kavosh.auth.AuthenticationReq;
import com.example.kavosh.auth.AuthenticationRes;
import com.example.kavosh.entity.UserReq;
import com.example.kavosh.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping(value = "/signUp" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationRes> signUp(@RequestBody UserReq userReq){
        return ResponseEntity.ok(service.singUp(userReq));
    }

    @PostMapping(value = "/signIn" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationRes> signUp(@RequestBody AuthenticationReq authenticationReq){
        return ResponseEntity.ok(service.singIn(authenticationReq));
    }
}
