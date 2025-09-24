package com.church.Management_System.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.church.Management_System.entity.User;
import com.church.Management_System.repository.UserRepository;



import java.util.*;

@Service
public class UserService implements UserDetailsService {
 @Autowired
 private UserRepository repo;

 public void save(User user) {
     repo.save(user);
 }

 @Override
 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user = repo.findById(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
     return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
 }
}
