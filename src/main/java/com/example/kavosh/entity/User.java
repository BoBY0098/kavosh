package com.example.kavosh.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(String fullName , String username , String password){
        setId(id);
        this.fullName = fullName;
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
