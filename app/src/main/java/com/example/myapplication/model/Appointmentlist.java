package com.example.myapplication.model;

public class Appointmentlist {
    String hospital_name ;
    String Timing;

    public Appointmentlist(String hospital_name, String timing, String date) {
        this.hospital_name = hospital_name;
        Timing = timing;
        Date = date;
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
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    String Date;
}
