package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Tokene;
import com.example.myapplication.model.tokee;
import com.example.myapplication.model.tokense;
import com.example.myapplication.util.T;
import com.example.myapplication.util.constants;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Empty;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Date;

public class Main7Activity extends AppCompatActivity {
TextView ee;
TextView dat;
TextView tim;
    Lists lists = Lists.getInstance();
    Doctors doctors =  lists.getDoctors();
TextView dep;
TextView doc;
    String timeadded;
    int aa = 0;
Bundle bundle;
String Hospital_name;
ImageButton imageButton;
ProgressBar progressBar;
Appointmentlist appointmentlist = new Appointmentlist();
Button  button;
FirebaseFirestore fb = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        bundle = getIntent().getExtras();
        ee = findViewById(R.id.ee);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        ee.setText(bundle.getString("Token"));
        dat = findViewById(R.id.dat);
        tim = findViewById(R.id.tim);
        dep = findViewById(R.id.dep);
        doc = findViewById(R.id.doc);
        button = findViewById(R.id.book_appointmen);
        imageButton = findViewById(R.id.edit);
        dat.setText(bundle.getString("dat"));
        dep.setText(bundle.getString("dep"));
        doc.setText(bundle.getString("doc"));
        tim.setText(bundle.getString("tim"));
        Hospital_name = bundle.getString("hospital");
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main6Activity.fa.finish();
                startActivity(new Intent(Main7Activity.this,Main6Activity.class));
                finish();
            }
        });
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(final View v) {
        progressBar.setVisibility(View.VISIBLE);
        Log.d("9876543210", "onClick: ");
        Lists lists = Lists.getInstance();
        String email1 = lists.getName();
         aa = email1.toLowerCase().charAt(0);
         appointmentlist.setHospital_name(Hospital_name);
         appointmentlist.setConfirmed("Pending");
         appointmentlist.setDate(bundle.getString("dat"));
         appointmentlist.setTiming(bundle.getString("tim"));
         appointmentlist.setToken(bundle.getString("Token"));
         appointmentlist.setDoctor_name(bundle.getString("doc"));
         appointmentlist.setCondition("upcoming");
         appointmentlist.setCc(bundle.getLong("timekaro"));
         timeadded = bundle.getString("dat") + Timestamp.now().getSeconds();
         appointmentlist.setTimeadded(timeadded);
        String  first_letter = Character.toString(email1.toLowerCase().charAt(0));
        constants cons = new constants();
        Log.d("98765432100", "onClick: " + aa );
        if(aa>96 && aa<103)
        {
            for (String letter : cons.A_F) {
                Log.d("98765432101", "onClick: " + "letter" + letter + " firstletter" + first_letter);
                if(first_letter.equals(letter)){
                    Log.d("98765432102", "onClick: ");
                    fb.collection("A-F").document(email1).collection("Appointmnet").document("bookings").collection("upcoming").document(timeadded).set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("98765432103", "onClick: ");
fb.collection("Hospital").document(Hospital_name).collection("Doctors").document(appointmentlist.getDoctor_name()).collection("Appointment").document(bundle.getString("dat")).collection("username").document("appointment").set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {
        deletingtoken();
        Log.d("lololololo3", "onComplete: ");
        Log.d("98765432104", "onClick: ");
        startActivity(new Intent(Main7Activity.this,Main4Activity.class));

        Main4Activity.fa.finish();
        Book_appointment.fa.finish();
        Main5Activity.fa.finish();
        Main6Activity.fa.finish();
        finish();

    }
}).addOnFailureListener(new OnFailureListener() {
    @SuppressLint("ResourceAsColor")
    @Override
    public void onFailure(@NonNull Exception e) {
        Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();

    }
});

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                        }
                    });

                    break;}

            } }

        else if(aa>102 && aa<109)
        {  Log.d("aif", "savePatie: ");
            for (String letter : cons.G_L) {
                Log.d("aiffor", "saveappointmentlist: " + letter);
                if(letter.equals(first_letter)){
                    Log.d("aifforif", "saveappointmentlist: ");
                    fb.collection("A-F").document(email1).collection("Appointmnet").document("bookings").collection("upcoming").document(timeadded).set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            fb.collection("Hospital").document(Hospital_name).collection("Doctors").document(appointmentlist.getDoctor_name()).collection("Appointment").document(bundle.getString("dat")).collection("username").document("appointment").set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    startActivity(new Intent(Main7Activity.this,Main4Activity.class));
                                    Main4Activity.fa.finish();
                                    Book_appointment.fa.finish();
                                    Main5Activity.fa.finish();
                                    Main6Activity.fa.finish();
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                        }
                    });break;


                }}
        }
        else if(aa>108 && aa<114)
        { for (String letter : cons.M_Q) {
            if(letter.equals(first_letter)){
                Log.d("gifgif", "onSuccess: " + email1 + " " + bundle.getString("dat") + "  " + new Timestamp(new Date()).now().getSeconds());
                fb.collection("M-Q").document(email1).collection("Appointmnet").document("bookings").collection("upcoming").document(bundle.getString("dat") + new Timestamp(new Date()).now().getSeconds()).set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        fb.collection("Hospital").document(Hospital_name).collection("Doctors").document(appointmentlist.getDoctor_name()).collection("Appointment").document(appointmentlist.getDoctor_name()).collection("username").document("appointment").set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(Main7Activity.this,Main4Activity.class));
                                Main4Activity.fa.finish();
                                Book_appointment.fa.finish();
                                Main5Activity.fa.finish();
                                Main6Activity.fa.finish();
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @SuppressLint("ResourceAsColor")
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                            }
                        });
                        aa = aa  +1;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                    }
                });

                break;
            }  ;}
        }
        else if(aa>113 && aa <116)
        { for (String letter : cons.R_S) {
            if(letter.equals(first_letter)){
                fb.collection("R-S").document(email1).collection("Appointmnet").document("bookings").collection("upcoming").document(bundle.getString("dat") + new Timestamp(new Date()).now().getSeconds()).set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        fb.collection("Hospital").document(Hospital_name).collection("Doctors").document(appointmentlist.getDoctor_name()).collection("Appointment").document(bundle.getString("dat")).collection("username").document("appointment").set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(Main7Activity.this,Main4Activity.class));
                                Main4Activity.fa.finish();
                                Book_appointment.fa.finish();
                                Main5Activity.fa.finish();
                                Main6Activity.fa.finish();
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @SuppressLint("ResourceAsColor")
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                    }
                });


                break;}  ;}
        }
        else if(aa> 115 && aa<123)
        { for (String letter : cons.T_Z) {
            if(letter.equals(first_letter)){
                fb.collection("T-Z").document(email1).collection("Appointmnet").document("bookings").collection("upcoming").document(bundle.getString("dat") + new Timestamp(new Date()).now().getSeconds()).set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        fb.collection("Hospital").document(Hospital_name).collection("Doctors").document(appointmentlist.getDoctor_name()).collection("Appointment").document(bundle.getString("dat")).collection("username").document("appointment").set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(Main7Activity.this,Main4Activity.class));
                                Main4Activity.fa.finish();
                                Book_appointment.fa.finish();
                                Main5Activity.fa.finish();
                                Main6Activity.fa.finish();
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @SuppressLint("ResourceAsColor")
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                    }
                });


                break;}  }
        }
        else
        {
            Log.d("other", "saveappointmentlist: ");
            fb.collection("OTHER").document(email1).collection("Appointmnet").document("bookings").collection("upcoming").document(bundle.getString("dat") + new Timestamp(new Date()).now().getSeconds()).set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    fb.collection("Hospital").document(Hospital_name).collection("Doctors").document(appointmentlist.getDoctor_name()).collection("Appointment").document(bundle.getString("dat")).collection("username").document("appointment").set(appointmentlist).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            startActivity(new Intent(Main7Activity.this,Main4Activity.class));
                            Main4Activity.fa.finish();
                            Book_appointment.fa.finish();
                            Main5Activity.fa.finish();
                            Main6Activity.fa.finish();
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                        }
                    });

                }
            }).addOnFailureListener(new OnFailureListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onFailure(@NonNull Exception e) {
                    Snackbar.make(v, "Try again sometime", Snackbar.LENGTH_LONG).setBackgroundTint(R.color.white).show();
                }
            });


        }
    }
});

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void deletingtoken() {

        fb.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(bundle.getString("dat")).collection("tokens").document(bundle.getString("tim")).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot = task.getResult();
                    if(documentSnapshot.exists())
                    {
                        tokense tok = new tokense();
                        tok.setTiming(documentSnapshot.get("timing").toString());
                        tok.setTimeadded(documentSnapshot.getLong("timeadded"));
                        tok.setToke((ArrayList<String>) documentSnapshot.get("toke"));
                        arranging((ArrayList)tok.getToke(),tok);
                        Log.d("lololololo1", "onComplete: ");
                    }

                }

            }
        });
    }

    private void arranging(ArrayList tokene , tokense tok) {

        String[] Toke = new String[tokene.size()];
        ArrayList<String> Ti = new ArrayList();
        for(int i=0 ; i< tokene.size(); i++){
            Toke[i] = tokene.get(i).toString();
            Log.d("lokkiiiii2", "arranging: " + Ti.size());
        }
        for(int i=0;i<Toke.length;i++){
            Log.d("lokkiiiii3", "arranging: " + Ti.size());
            if(Toke[i].equals(bundle.getString("Token"))){
                for(int j=i;j<Toke.length-1;j++){
                    Toke[j] = Toke[j+1];
                    Log.d("lokkiiiii4", "arranging: " + Ti.size());
                }
                Log.d("lokkiiiii5", "arranging: " + Ti.size());
            }
        }
        for (int k = 0; k<Toke.length-1;k++){
Ti.add(Toke[k]);
            Log.d("lokkiiiii6", "arranging: " + Ti.size());

        }
        Log.d("lokkiiiii", "arranging: " + Ti.size());
       if(Ti.size()==0){
           fb.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(bundle.getString("dat")).collection("tokens").document(tok.getTiming()).delete();
       }
       else{
           tok.setToke(Ti);
           fb.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(bundle.getString("dat")).collection("tokens").document(tok.getTiming()).set(tok);
       }
        Log.d("lololololo2", "onComplete: ");  }
}
