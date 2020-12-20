package com.example.myapplication.profile_image_api;

import android.app.Application;

public class Profile_Image extends Application {
    String Url ;
    static Profile_Image profileImageUrl;
    public static Profile_Image getInstance(){
        if(profileImageUrl == null){
            profileImageUrl = new Profile_Image();

        }return profileImageUrl;
    }

    public Profile_Image() {
    }

    public Profile_Image(String url) {
        Url = url;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
