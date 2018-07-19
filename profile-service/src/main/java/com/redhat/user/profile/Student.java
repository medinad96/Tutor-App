package com.redhat.user.profile;


import org.infinispan.protostream.annotations.ProtoField;

public class Student extends User {


    @ProtoField(number = 20)
    public String classHelp;
    @ProtoField(number = 21)
    public String placeToMeet;

    public Student() {

    }

    public Student (String userId, String firstName, String lastName, String phoneNumber, String email, String description, String placeToMeet, String classHelp){
        super(userId,"student",firstName,lastName,phoneNumber,email,description);
        this.placeToMeet = placeToMeet;
        this.classHelp = classHelp;
    }


    @Override
    public String toString() {
        return String.format(
                "Student[userId=%s, userType='%s' firstName='%s', lastName='%s', phoneNumber='%s', email='%s', description='%s', placeToMeet='%s', classHelp='%s']",
                getUserId(), getUserType(), getFirstName(), getLastName(), getPhoneNumber(),getEmail(),getDescription(), placeToMeet, classHelp);
    }

    public String getClassHelp() {
        return classHelp;
    }

    public void setClassHelp(String classHelp) {
        this.classHelp = classHelp;
    }

    public String getPlaceToMeet() {
        return placeToMeet;
    }

    public void setPlaceToMeet(String placeToMeet) {
        this.placeToMeet = placeToMeet;
    }


}