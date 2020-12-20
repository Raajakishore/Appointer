package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Patient;
import com.example.myapplication.util.Main9Activity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    EditText ed;
    Patient patient = new Patient();
    private Button login;
    TextView forgot;
   public static Main2Activity fa;
    private Button signup;
    private TextView incorrect;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    FirebaseAuth.AuthStateListener authStateListener;
    FirebaseUser Current;
    FirebaseFirestore firebaseFirestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
        email=findViewById(R.id.ed1);
        password=findViewById(R.id.ed2);
        progressBar=findViewById(R.id.progressBar30);
        login=findViewById(R.id.tt2);
        signup=findViewById(R.id.tt3);
        forgot = findViewById(R.id.forgot);
        fa = this;
        incorrect = findViewById(R.id.incorrect);
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
progressBar.setVisibility(View.INVISIBLE);
forgot.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       ed = new EditText(v.getContext());
        ed.setBackgroundResource(R.drawable.rf);
        AlertDialog.Builder al = new AlertDialog.Builder(v.getContext());
        al.setTitle("Enter email to receive reset password link");
        al.setView(ed);
        al.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

         String h ="";
                h = ed.getText().toString();
                if(!h.isEmpty()){
                    firebaseAuth.sendPasswordResetEmail(h).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Reset link has been sent to your email",Toast.LENGTH_LONG).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            String o = e.toString();
                            if(o.contains("The email address is badly formatted")){
                                Toast.makeText(getApplicationContext(),"Enter correct emailid",Toast.LENGTH_LONG).show();
                            }
                            if(o.contains("There is no user record corresponding to this identifier")){
                                Toast.makeText(getApplicationContext(),"This email has not signed up",Toast.LENGTH_LONG).show();
                            }
                            Log.d("huhuh", "onFailure: " + o);
                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter emailid",Toast.LENGTH_LONG).show();
                }

            }
        });
        al.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        al.create().show();
    }
});
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                Current = firebaseAuth.getCurrentUser();
                if(Current!=null){
                }else {

                }}
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                login_credentials(email.getText().toString().trim(),password.getText().toString().trim());}});




        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this,Main3Activity.class));

            }
        });
    }

    private void login_credentials(final String emailid, final String passwordd) {
        if (!emailid.isEmpty() && !passwordd.isEmpty()) {
            firebaseAuth.signInWithEmailAndPassword(emailid, passwordd).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    if(Current.isEmailVerified()) {
                        final Lists l = Lists.getInstance();
                        l.setName(emailid);
                        l.setPassword(passwordd);
                        l.setFirebaseAuth(firebaseAuth);
                        firebaseFirestore.collection(l.getCAPITALS()).document(emailid).collection("profile").document("profile").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                if(documentSnapshot!=null){


                                if (documentSnapshot.get("password").toString().equals(passwordd)) {
                                    progressBar.setVisibility(View.INVISIBLE);
                                    startActivity(new Intent(Main2Activity.this, Main4Activity.class));
                                    finish();
                                }
                                else{
                                    firebaseFirestore.collection(l.getCAPITALS()).document(emailid).collection("profile").document("profile").update("password",passwordd).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            progressBar.setVisibility(View.INVISIBLE);
                                            startActivity(new Intent(Main2Activity.this, Main4Activity.class));
                                            finish();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }}
                                else{
                                    Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
                                }
                            }

                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(),"Try Again",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else{
                        Current.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(Main2Activity.this, Main9Activity.class));
                            }
                        });

                    }

//                }
//            }).}}
}}).
            addOnFailureListener(new OnFailureListener() {
                                @Override
                public void onFailure(@NonNull Exception e) {
                                    progressBar.setVisibility(View.INVISIBLE);
                    Log.d("notslogingin", "onFailure: "  + e.toString());
                    incorrect.setText("Username or Password is incorrect");

                }
            });
        }
else{
            progressBar.setVisibility(View.INVISIBLE);
    incorrect.setText("Please enter username and password");

  }}
    @Override
    protected void onPause() {
        super.onPause();
        if(authStateListener!=null){
            firebaseAuth.removeAuthStateListener(authStateListener);
        }}
    @Override
    protected void onStart() {
        super.onStart();
        Current = firebaseAuth.getCurrentUser();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}


