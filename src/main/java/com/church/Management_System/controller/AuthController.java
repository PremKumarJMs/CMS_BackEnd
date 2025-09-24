package com.church.Management_System.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.church.Management_System.entity.User;
import com.church.Management_System.jwt.JwtUtil;
import com.church.Management_System.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
 @Autowired
 private AuthenticationManager authManager;
 @Autowired
 private UserService userService;
 @Autowired
 private JwtUtil jwtUtil;

 @PostMapping("/register")
 public String register(@RequestBody User user) {
     userService.save(user);
     return "User registered!";
 }

 @PostMapping("/login")
 public String login(@RequestBody User user) throws Exception {
     try {
         authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
     } catch (Exception e) {
         throw new Exception("Invalid Credentials");
     }

     UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
     return jwtUtil.generateToken(userDetails.getUsername());
 }

 @GetMapping("/welcome")
 public String welcome() {
     return "Welcome! You are authenticated.";
 }
}

