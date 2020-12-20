package com.example.myapplication.model;

import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class Doctors {
    private String name;
    private String stars;
    private String Hospital_name;
    private String Department;




    public String getDepartment() {
        return Department;
    }

//    private Uri uri;

    public String getName() {
        return name;
    }

   public String getStars() {
        return stars;
    }



    public String getHospital_name() {
        return Hospital_name;
    }


    public String getDoctors_Department() {
        return Department;
    }


//    public Uri getUri() {
//        return uri;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public void setHospital_name(String hospital_name) {
        Hospital_name = hospital_name;
    }

    public void setDepartment(String department) {
        Department = department;
    }
}


