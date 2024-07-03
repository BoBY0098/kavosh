package com.example.kavosh.entity;

import lombok.Data;

@Data
public class UserRes {

    private Long userId;

    private String fullName;

    private String username;

    public UserRes(Long userId , String fullName , String username){
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
    }
}
