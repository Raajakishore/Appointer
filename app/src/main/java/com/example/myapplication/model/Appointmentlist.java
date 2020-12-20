package com.example.myapplication.model;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

public class Appointmentlist {
    String hospital_name ;
    String Timing;
    String doctor_name;
    String confirmed;
    String date;
    String token;
    String condition;
long cc;
    String timeadded;
    public long getCc() {
        return cc;
    }

    public void setCc(long cc) {
        this.cc = cc;
    }






    public String getTimeadded() {
        return timeadded;
    }

    public void setTimeadded(String timeadded) {
        this.timeadded = timeadded;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Appointmentlist() {
    }

    public Appointmentlist(String hospital_name, String timing, String doctor_name, String confirmed, String date) {
        this.hospital_name = hospital_name;
        Timing = timing;
        this.doctor_name = doctor_name;
        this.confirmed = confirmed;
        this.date = date;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String timing) {
        Timing = timing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
