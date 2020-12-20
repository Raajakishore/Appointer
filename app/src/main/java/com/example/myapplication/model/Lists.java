package com.example.myapplication.model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Main4Activity;
import com.example.myapplication.util.constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.example.myapplication.model.Hospital;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Lists extends Application {

    public static Lists list;
    Hospital hospital;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Doctors doctors;
    FirebaseAuth firebaseAuth;

    String name;
    String user_name;
    String CAPITALS;
    int cc;

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public void setFirebaseAuth(FirebaseAuth firebaseAuth) {
        this.firebaseAuth = firebaseAuth;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    //    FirebaseApp.initializeApp(this);
//FirebaseFirestore fb = FirebaseFirestore.getInstance();
//CollectionReference c;
    String abc = "";

//    public CollectionReference getC() {
//        return c;
//    }
//
//    public void setC(CollectionReference c) {
//        this.c = c;
//    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getCAPITALS() {
        return CAPITALS;
    }

    public void setCAPITALS(String CAPITALS) {
        this.CAPITALS = CAPITALS;
    }

    public String getName() {
        return name;
    }

    public Doctors getDoctors() {
        return doctors;
    }

    public void setDoctors(Doctors doctors) {
        this.doctors = doctors;
    }

    public void setName(String name) {

        this.name = name;
        setter();
    }

    private void setter() {
        int aa = 0;

        String email1 = Lists.getInstance().getName();
        constants cons = new constants();
        String first_letter = Character.toString(email1.toLowerCase().charAt(0));
        aa = email1.toLowerCase().charAt(0);
        if(aa>96 && aa<103)
        {
            for (String letter : cons.A_F) {

                if(letter.equals(first_letter)){

//                    c =      fb.collection("A-F").document(email1).collection("Appointmnet");

                    abc = "A-F";
                    break;}

            }

        }

        else if(aa>102 && aa<109)
        {
            for (String letter : cons.G_L) {

                if(letter.equals(first_letter)){

//                 c =   fb.collection("G-L").document(email1).collection("Appointmnet");
                    abc = "G-L";  break;


                }}
        }
        else if(aa>108 && aa<114)
        { for (String letter : cons.M_Q) {
            if(letter.equals(first_letter)){
//             c =   fb.collection("M-Q").document(email1).collection("Appointmnet");
                abc = "M-Q";
                break;
            }  ;}
        }
        else if(aa>113 && aa <116)
        { for (String letter : cons.R_S) {
            if(letter.equals(first_letter)){
//           c =     fb.collection("R-S").document(email1).collection("Appointmnet");
                abc = "R-S";

                break;}  ;}
        }
        else if(aa> 115 && aa<123)
        { for (String letter : cons.T_Z) {
            if(letter.equals(first_letter)){
//            c =    fb.collection("T-Z").document(email1).collection("Appointmnet");
                abc = "T-Z";

                break;}  }
        }
        else
        {
            Log.d("other", "savePatient: ");
//         c =   fb.collection("OTHER").document(email1).collection("Appointmnet");
            abc = "OTHER";
        }


        setCAPITALS(abc);


    }

    public static Lists getInstance(){
        if(list == null){
            list = new Lists();
        }
        else{

        }
        return list;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    //    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
//    FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
//    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//    Main4Activity m = new Main4Activity();
//    ArrayList<Hospital> hospitalLists = new ArrayList<>();
//    public  ArrayLists<Hospital> getting_lists(final Callbacking callback){
//      firebaseFirestore.collection("Hospital").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//        @Override
//        public void onComplete(@NonNull Task<QuerySnapshot> task) {
//            if(task.isSuccessful()){
//                for(QueryDocumentSnapshot d:task.getResult()){
//                   hospitalLists.add(d.toObject(Hospital.class));
//                }
//                callback.calling(hospitalLists);
//                Log.d("asdfghjkl", "onComplete: " + hospitalLists.size());
//            }
//
////
//        }
//    });
//        Log.d("eeeeeeee", "onComplete: " + hospitalLists.size());
//
//   return hospitalLists;
//
// }

}
