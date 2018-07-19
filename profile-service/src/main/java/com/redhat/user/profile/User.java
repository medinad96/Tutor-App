package com.redhat.user.profile;

//import org.springframework.data.annotation.Id;

import org.infinispan.protostream.annotations.ProtoField;
import org.infinispan.protostream.annotations.ProtoMessage;
import org.infinispan.protostream.descriptors.JavaType;
import org.infinispan.protostream.descriptors.Type;

import java.io.Serializable;

@ProtoMessage(name = "AppUser")
public class User implements Serializable {

    //@Id
    @ProtoField(number = 1)
    public String userId;
    @ProtoField(number = 2)
    public String userType;
    @ProtoField(number = 3)
    public String firstName;
    @ProtoField(number = 4)
    public String lastName;
    @ProtoField(number = 5)
    public String phoneNumber;
    @ProtoField(number = 6)
    public String email;
    @ProtoField(number = 7)
    public String description;

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