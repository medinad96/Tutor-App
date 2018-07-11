package com.redhat.user.profile;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class User implements Serializable {

    @Id
    private String userId;
    private String userType;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String description;

    public User() {

    }
    public User(String userId, String userType, String firstName, String lastName, String phoneNumber, String email, String description) {
        this.userId = userId;
        this.userType = userType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format(
                "User[userId=%d, userType='%s' firstName='%s', lastName='%s', phoneNumber='%d', email='%s', description='%s']",
                userId, firstName, lastName, phoneNumber,email,description);
    }

    public String getUserId() {return userId;}

    public String getUserType() {
        return userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId){this.userId = userId;};

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}