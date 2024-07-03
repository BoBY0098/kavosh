package com.example.kavosh.Controller;

import com.example.kavosh.Service.UserService;
import com.example.kavosh.entity.User;
import com.example.kavosh.entity.UserReq;
import com.example.kavosh.entity.UserRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preauth/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping(value = "/getAll" ,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserRes>> getAllUsers(){
        List<UserRes> users = service.allUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping(value = "/save" , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody UserReq userReq){
        service.saveUser(userReq);
        return ResponseEntity.ok("User Created Successfully");
    }
}
