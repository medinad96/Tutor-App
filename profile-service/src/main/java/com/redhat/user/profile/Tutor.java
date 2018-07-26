package com.redhat.user.profile;


import org.infinispan.protostream.annotations.ProtoField;

public class Tutor extends User {


    @ProtoField(number = 10)
    public String placeToMeet;
    @ProtoField(number = 11)
    public String classesToHelp;

    public Tutor() {

    }
    public Tutor (String userId, String firstName, String lastName, String phoneNumber, String email, String description, String placeToMeet, String classesToHelp){
        super(userId,"tutor", firstName,lastName,phoneNumber,email,description);
        this.placeToMeet = placeToMeet;
        this.classesToHelp = classesToHelp;

    }

    @Override
    public String toString() {
        return String.format(
                "Tutor[userId=%s, userType='%s' firstName='%s', lastName='%s', phoneNumber='%s', email='%s', description='%s', placeToMeet='%s', classesToHelp='%s']",
                getUserId(), getUserType(), getFirstName(), getLastName(), getPhoneNumber(),getEmail(),getDescription(), placeToMeet, classesToHelp);
    }

    public String getPlaceToMeet() {
        return placeToMeet;
    }

    public void setPlaceToMeet(String placeToMeet) {
        this.placeToMeet = placeToMeet;
    }

    public String getClassesToHelp() {
        return classesToHelp;
    }

    public void setClassesToHelp(String classesToHelp) {
        this.classesToHelp = classesToHelp;
    }



}