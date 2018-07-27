package com.redhat.user.model;

import org.infinispan.protostream.annotations.ProtoField;
import org.infinispan.protostream.annotations.ProtoMessage;


@ProtoMessage(name = "AppAppointment")
public class Appointment {

    @ProtoField(number = 30)
    public String appointmentId;
    @ProtoField(number = 31)
    public String appointmentAuthor;
    @ProtoField(number = 32)
    public String appointmentRecipient;
    @ProtoField(number = 33)
    public String appointmentTitle;
    @ProtoField(number = 34)
    public String appointmentDescription;
    @ProtoField(number = 35)
    public String appointmentStatus;


    public Appointment(){

    }

    public Appointment(String appointmentId, String appointmentAuthor, String appointmentRecipient, String appointmentTitle, String appointmentDescription, String appointmentStatus) {
        this.appointmentId = appointmentId;
        this.appointmentAuthor = appointmentAuthor;
        this.appointmentRecipient = appointmentRecipient;
        this.appointmentTitle = appointmentTitle;
        this.appointmentDescription = appointmentDescription;
        this.appointmentStatus = appointmentStatus;
    }


    @Override
    public String toString() {
        return String.format(
                "Tutor[appointmentId=%s, appointmentAuthor=%s, appointmentRecipient=%s, appointmentTitle='%s' appointmentDescription='%s', appointmentStatus='%s']",
                getAppointmentId(), getAppointmentTitle(),getAppointmentAuthor(),getAppointmentRecipient(), getAppointmentDescription(), getAppointmentStatus());
    }



    public String getAppointmentId() {
        return appointmentId;
    }

    public void setappointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentAuthor() {
        return appointmentAuthor;
    }

    public void setAppointmentAuthor(String appointmentAuthor) {
        this.appointmentAuthor = appointmentAuthor;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentRecipient() {
        return appointmentRecipient;
    }

    public void setAppointmentRecipient(String appointmentRecipient) {
        this.appointmentRecipient = appointmentRecipient;
    }


}
