package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.data.Databasehandler;
import com.example.myapplication.model.Patient;
import com.google.android.material.snackbar.Snackbar;

public class Main3Activity extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private EditText password;
    private EditText gender;
    private EditText age;
    private EditText contact;
    private EditText bloodgrp;
    private EditText address;
    private Button save;
    private Databasehandler db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db=new Databasehandler(this);
        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        gender=findViewById(R.id.gender);
        age=findViewById(R.id.age);
        contact=findViewById(R.id.contact);
        bloodgrp=findViewById(R.id.bloodgrp);
        address=findViewById(R.id.address);
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(name.getText().toString().isEmpty())&&
                   !(username.getText().toString().isEmpty())&&
                   !(password.getText().toString().isEmpty())&&
                    !(gender.getText().toString().isEmpty())&&
                   !(age.getText().toString().isEmpty())&&
                    !(contact.getText().toString().isEmpty())&&
                   !(bloodgrp.getText().toString().isEmpty())&&
                   !(address.getText().toString().isEmpty())){
                    savePatient(v);
                }
                else {
                    Snackbar.make(v,"Empty Fields Are Not Allowed",Snackbar.LENGTH_LONG).show();

                }
            }
        });

    }

    private void savePatient(View v) {
        Patient patient= new Patient();
        String name1=name.getText().toString().trim();
        String username1=username.getText().toString().trim();
        String password1=password.getText().toString().trim();
        String gender1=gender.getText().toString().trim();
        int age1=Integer.parseInt(age.getText().toString().trim());
        String contact1=contact.getText().toString().trim();
        String bloodgrp1=bloodgrp.getText().toString().trim();
        String address1=address.getText().toString().trim();
        patient.setUserName(username1);
        patient.setPatientName(name1);
        patient.setPassword(password1);
        patient.setGender(gender1);
        patient.setAge(age1);
        patient.setContact(contact1);
        patient.setBloodgp(bloodgrp1);

        Log.d("patientdetail", "savePatient: "+patient);
        db.addPatient(patient);
        Snackbar.make(v,"SUCCESSFULLY REGISTERED",Snackbar.LENGTH_LONG).show();

    }
}
