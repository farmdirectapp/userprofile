package com.receiptwallet.profile.request.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoginResponse  extends Response{
    private static final long serialVersionUID = 1L;

    private String profileId;

    private String emailId;

    private String firstName;

    private String lastName;

    private String middleName;

    private String phone;

    private String deviceId;

    private Date dob;

    private String secutityToken;

    public LoginResponse(){};
    public LoginResponse(int errorCode, String message, boolean status) {
        super(errorCode, message, status);
    }

    public LoginResponse(String profileId, String emailId,
                         String firstName, String lastName,
                         String middleName, String phone,
                         String deviceId, Date dob) {
        this.profileId = profileId;
        this.emailId = emailId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phone = phone;
        this.deviceId = deviceId;
        this.dob = dob;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSecutityToken() {
        return secutityToken;
    }

    public void setSecutityToken(String secutityToken) {
        this.secutityToken = secutityToken;
    }
}
