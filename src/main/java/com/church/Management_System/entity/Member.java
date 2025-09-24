package com.church.Management_System.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.church.Management_System.status.Gender;
import com.church.Management_System.status.MembershipStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

@Entity
@Data
public class Member {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phone;

	    private LocalDate dateOfBirth;
	    private Gender gender;
	    private String address;

	    private LocalDate membershipDate;

	    private MembershipStatus status = MembershipStatus.ACTIVE;
	    private String notes;

	    private String photoUrl;

	    @Column(updatable = false)
	    private LocalDateTime createdAt;

	    private LocalDateTime updatedAt;

	    @PrePersist
	    protected void onCreate() {
	        createdAt = LocalDateTime.now();
	        updatedAt = LocalDateTime.now();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updatedAt = LocalDateTime.now();

}
}