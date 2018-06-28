package com.redhat.user.profile;


public class Tutor extends User<String> {

    private String placeToMeet;
    private String classesToHelp;

    public Tutor (Long userId, String userType, String firstName, String lastName, Long phoneNumber, String email, String description, String placeToMeet, String classesToHelp){
        super(userId,firstName,lastName,phoneNumber,email,description);
        this.userType = "Tutor";
        this.placeToMeet = placeToMeet;
        this.classesToHelp = classesToHelp;

    }

    @Override
    public String toString() {
        return String.format(
                "Tutor[userId=%d, userType='%s' firstName='%s', lastName='%s', phoneNumber='%d', email='%s', description='%s', placeToMeet='%s', classesToHelp='%s']",
                userId, userType, firstName, lastName, phoneNumber,email,description, placeToMeet, classesToHelp);
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