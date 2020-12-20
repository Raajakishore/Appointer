package com.example.myapplication.model;

import android.net.Uri;

import java.util.ArrayList;

public class Hospital {
    private  String Hospital_name;

    private String Address;
    private String City;
    private String District;
//    private Uri uri;
    public Hospital() {
    }

    public Hospital(String hospital_name, String address, String city, String district) {
        Hospital_name = hospital_name;
        Address = address;
        City = city;
        District = district;
    }

    public String getHospital_name() {
        return Hospital_name;
    }


    public String getCity() {
        return City;
    }

    public String getDistrict() {
        return District;
    }

    public String getAddress() {
        return Address;
    }
}
