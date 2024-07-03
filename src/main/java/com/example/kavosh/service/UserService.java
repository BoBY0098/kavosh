package com.example.kavosh.service;

import com.example.kavosh.entity.User;
import com.example.kavosh.entity.UserReq;
import com.example.kavosh.entity.UserRes;
import com.example.kavosh.exception.ServiceException;
import com.example.kavosh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(UserReq userReq){
        User newUser = new User(userReq.getFullName() , userReq.getUsername() , userReq.getPassword());
        userRepository.save(newUser);
    }

    public List<UserRes> allUsers(){
        List<User> users = userRepository.findAll();
        List<UserRes> usersRes = new ArrayList<>();
        for (User user : users) {
            UserRes userRes = new UserRes(user.getId() , user.getFullName() , user.getUsername());
            usersRes.add(userRes);
        }
        return usersRes;
    }

    public Boolean loginUser(String username , String password){
        User user = validateUsername(username);
        String userPassword = user.getPassword();
        if(!userPassword.equals(password)){
            throw new ServiceException("PassWorD Doesn't MATcH !!!");
        }
        return true;
    }

    private User validateUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(()-> new ServiceException("User Not FounD !!!"));
    }
}
