package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.health.TimerStat;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Tokene;
import com.example.myapplication.model.tokee;
import com.example.myapplication.util.T;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;
import com.google.protobuf.TimestampOrBuilder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

public class MainActivity extends AppCompatActivity {

TextView tt;
FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

Lists lists = Lists.getInstance();
Doctors doctors;
FirebaseFirestore f = FirebaseFirestore.getInstance();
FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
FirebaseAuth.AuthStateListener authStateListener ;
FirebaseUser Current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = findViewById(R.id.textView2);



        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Current = firebaseAuth.getCurrentUser();
                if(Current!=null){
                }else {

                }}
        };
 Current =  firebaseAuth.getCurrentUser();
 if(Current!=null){Log.d("96969696", "onSuccess: " + Current.getEmail().toString());

    lists.setName( Current.getEmail().toString());
    lists.setFirebaseAuth(firebaseAuth);
     new CountDownTimer(1000,1000){

         @Override
         public void onTick(long millisUntilFinished) {

         }

         @Override
         public void onFinish() {
             if(Current.isEmailVerified()){
                 Log.d("senorita", "onFinish: " + Current.isEmailVerified());
             startActivity(new Intent(MainActivity.this,Main4Activity.class));
             finish();}
             else   {
                 Log.d("=====", "onFinish: " + Current.isEmailVerified());
                 startActivity(new Intent(MainActivity.this,Main2Activity.class));
                 finish();
             }
         }
     }.start();
 }
 else{

     new CountDownTimer(1000,1000){

         @Override
         public void onTick(long millisUntilFinished) {

         }

         @Override
         public void onFinish() {

             startActivity(new Intent(MainActivity.this,Main2Activity.class));
             finish();
         }
     }.start();
 }}}
//
////
////        Appointmentlist ai = new Appointmentlist();
////        ai.setCondition("previous");
////        ai.setCc(2020020200200l);
////        ai.setToken("3");
////        ai.setHospital_name("123");
////        ai.setTiming("1:00AM - 2:00AM");
////        ai.setDate("2-02-2020");
////        ai.setConfirmed("confirmed");
////        ai.setDoctor_name("Jianna");
////       ai.setTimeadded("2-02-2020" + Timestamp.now().getSeconds());
////
////        firebaseFirestore.collection("A-F").document("A").collection("Appointmnet").document("bookings").collection("previous").document("2-02-2020" +Timestamp.now().getSeconds()).set(ai);
////ai.setDate("3-02-2020");
////ai.setCc(2020020300200l);
////ai.setTimeadded("3-02-2020" + Timestamp.now().getSeconds());
////    firebaseFirestore.collection("A-F").document("A").collection("Appointmnet").document("bookings").collection("previous").document("3-02-2020" +Timestamp.now().getSeconds()).set(ai).addOnSuccessListener(new OnSuccessListener<Void>() {
////        @Override
////        public void onSuccess(Void aVoid) {
////
////        }
////    });
//       }
//    void countdown(){
//
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if(authStateListener!=null){
//            firebaseAuth.removeAuthStateListener(authStateListener);
//        }}
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Current = firebaseAuth.getCurrentUser();
//        firebaseAuth.addAuthStateListener(authStateListener);
//    }}

        //        lists = Lists.getInstance();
//        doctors = lists.getDoctors();
//       String  datee = "10-06-2020";
//        firebaseFirestore.collection("Hospital").document("123").collection("Doctors").document("Jianna").collection("Token").document(datee).collection("tokens").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if (queryDocumentSnapshots != null) {
//                    for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
//                        if(documentSnapshot.getId().toString().equals("10:00PM - 11:00PM")){
//                            Log.d("69696969", "onSuccess: " + documentSnapshot.getId().toString());
//                            documentSnapshot.toObject(tokee.class);
//                            Tokene tokene = new Tokene();
//
//
//                        }
//                        else{
//
//                        }
//                    }
//                }
//            }
//        });


//
//    }}

