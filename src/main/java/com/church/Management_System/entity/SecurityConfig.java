package com.church.Management_System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SecurityConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer securityConfigId;
    private Integer pwdResetDays;
    private Integer failedCount;
    private String defaultPwd;

    public SecurityConfig(){}

    public SecurityConfig(Integer securityConfigId, Integer pwdResetDays, Integer failedCount, String defaultPwd) {
        this.securityConfigId = securityConfigId;
        this.pwdResetDays = pwdResetDays;
        this.failedCount = failedCount;
        this.defaultPwd = defaultPwd;
    }

    public Integer getSecurityConfigId() {
        return securityConfigId;
    }

    public void setSecurityConfigId(Integer securityConfigId) {
        this.securityConfigId = securityConfigId;
    }

    public Integer getPwdResetDays() {
        return pwdResetDays;
    }

    public void setPwdResetDays(Integer pwdResetDays) {
        this.pwdResetDays = pwdResetDays;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public String getDefaultPwd() {
        return defaultPwd;
    }

    public void setDefaultPwd(String defaultPwd) {
        this.defaultPwd = defaultPwd;
    }

    @Override
    public String toString() {
        return "SecurityConfig [defaultPwd=" + defaultPwd + ", failedCount=" + failedCount + ", pwdResetDays="
                + pwdResetDays + ", securityConfigId=" + securityConfigId + "]";
    }

}

