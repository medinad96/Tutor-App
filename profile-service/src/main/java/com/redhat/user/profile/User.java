package com.redhat.user.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;
    private String userType;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String description;

    public User(Long userId, String userType, String firstName, String lastName, Long phoneNumber, String email, String description) {
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

    public String getUserId() {return userId}

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

    public String setUserId(String userId){this.userId = userId};

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