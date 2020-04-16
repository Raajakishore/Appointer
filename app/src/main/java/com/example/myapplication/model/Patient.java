package com.example.myapplication.model;

public class Patient {
    private int id;
    private String patientName;
    private String userName;
    private String password;
    private String address;
    private String bloodgp;
    private String gender;
    private String dob;
    private String contact;

    public Patient() {
    }

    public Patient(int id, String patientName, String userName, String password, String address, String bloodgp, String gender, String dob, String contact) {
        this.id = id;
        this.patientName = patientName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.bloodgp = bloodgp;
        this.gender = gender;
        this.dob = dob;
        this.contact = contact;
    }

    public Patient(String patientName, String userName, String password, String address, String bloodgp, String gender, String dob, String contact) {
        this.patientName = patientName;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.bloodgp = bloodgp;
        this.gender = gender;
        this.dob = dob;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodgp() {
        return bloodgp;
    }

    public void setBloodgp(String bloodgp) {
        this.bloodgp = bloodgp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
