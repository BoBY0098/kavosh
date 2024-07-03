package com.example.kavosh.Service;

import com.example.kavosh.Repository.UserRepository;
import com.example.kavosh.entity.User;
import com.example.kavosh.entity.UserReq;
import com.example.kavosh.entity.UserRes;
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
}
