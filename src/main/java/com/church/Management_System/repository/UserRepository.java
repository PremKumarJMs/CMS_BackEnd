package com.church.Management_System.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.church.Management_System.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
