package com.church.Management_System.entity;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OldPasswords {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oldPasswordId;
    private String encryptedPassword;
    private Integer passwordOwnerId;
	@CreationTimestamp
	private Date createdDate;

	public OldPasswords() {

	}

	public OldPasswords(Long oldPasswordId, String encryptedPassword, Integer passwordOwnerId) {
		super();
		this.oldPasswordId = oldPasswordId;
		this.encryptedPassword = encryptedPassword;
		this.passwordOwnerId = passwordOwnerId;
	}

	public Long getId() {
		return oldPasswordId;
	}
	public void setId(Long oldPasswordId) {
		this.oldPasswordId = oldPasswordId;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public Integer getPasswordOwnerId() {
		return passwordOwnerId;
	}
	public void setPasswordOwnerId(Integer passwordOwnerId) {
		this.passwordOwnerId = passwordOwnerId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "OldPasswords [oldPasswordId=" + oldPasswordId + ", encryptedPassword=" + encryptedPassword
				+ ", passwordOwnerId=" + passwordOwnerId + ", createdDate=" + createdDate + "]";
	}

}

