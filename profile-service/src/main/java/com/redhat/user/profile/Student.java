package com.redhat.user.profile;


public class Student extends User<String> {


    private String classHelp;
    private String placeToMeet;

    public Student (Long userId, String userType, String firstName, String lastName, Long phoneNumber, String email, String description, String placeToMeet, String classHelp){
        super(userId,userType,firstName,lastName,phoneNumber,email,description);
        this.userType = "Student";
        this.placeToMeet = placeToMeet;
        this.classHelp = classHelp;
    }


    @Override
    public String toString() {
        return String.format(
                "Student[userId=%d, userType='%s' firstName='%s', lastName='%s', phoneNumber='%d', email='%s', description='%s', placeToMeet='%s', classHelp='%s']",
                userId, userType, firstName, lastName, phoneNumber,email,description, placeToMeet, classHelp);
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