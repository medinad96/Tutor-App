package com.redhat.user.profile;


public class Student extends User {


    private String classHelp;
    private String placeToMeet;

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
                "Tutor[userId=%s, userType='%s' firstName='%s', lastName='%s', phoneNumber='%s', email='%s', description='%s', placeToMeet='%s', classesToHelp='%s']",
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