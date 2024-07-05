package com.example.kavosh.service;

import com.example.kavosh.auth.AuthenticationReq;
import com.example.kavosh.auth.AuthenticationRes;
import com.example.kavosh.entity.Role;
import com.example.kavosh.entity.User;
import com.example.kavosh.entity.UserReq;
import com.example.kavosh.exception.ServiceException;
import com.example.kavosh.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationRes singUp(UserReq userReq) {
        var user = User.builder()
                .fullName(userReq.getFullName())
                .username(userReq.getUsername())
                .password(passwordEncoder.encode(userReq.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationRes.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationRes singIn(AuthenticationReq authenticationReq) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationReq.getUsername(),
                        authenticationReq.getPassword()
                )
        );
        var user = userRepository.findByUsername(authenticationReq.getUsername())
                .orElseThrow(()-> new ServiceException("User Not Found"));
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationRes.builder()
                .token(jwtToken)
                .build();
    }
}
