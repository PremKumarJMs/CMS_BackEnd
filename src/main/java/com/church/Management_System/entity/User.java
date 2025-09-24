package com.church.Management_System.entity;



import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
 @Id
 private String username;
 private String password;
}
