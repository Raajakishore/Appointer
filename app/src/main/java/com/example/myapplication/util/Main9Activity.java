package com.example.myapplication.util;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.Main2Activity;
import com.example.myapplication.Main4Activity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Lists;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main9Activity extends AppCompatActivity {
TextView link;
    CountDownTimer c;
FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
FirebaseUser user = firebaseAuth.getCurrentUser();
Lists lists=Lists.getInstance();
TextView resend;
ProgressBar p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        p = findViewById(R.id.progressBar4);
    link     = findViewById(R.id.link);
    p.setVisibility(View.INVISIBLE);
    resend = findViewById(R.id.resend);
    resend.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            p.setVisibility(View.VISIBLE);
            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    p.setVisibility(View.INVISIBLE);
                }
            });
        }
    });
    c =    new CountDownTimer(100000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("9999998585", "onTick: " + "/./.");
                if(user!= null){
                    Log.d("gatee", "onTick: " + user.getEmail().toString());
                    firebaseAuth.signInWithEmailAndPassword(lists.getName(),lists.getPassword()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Log.d("loggedinnn", "onSuccess: ");
                            if(user.isEmailVerified()){
                                Main2Activity.fa.finish();

                                Log.d("awersdfy", "onTick: ");
                                startActivity(new Intent(Main9Activity.this, Main4Activity.class));
                                c.cancel();
                                finish();

                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("failing", "onFailure: " + e.toString());
                        }
                    });
                }
                Log.d("qqqqqqq", "onTick: " + user.isEmailVerified());

            }

            @Override
            public void onFinish() {

            }
        };
c.start();
    }
}
