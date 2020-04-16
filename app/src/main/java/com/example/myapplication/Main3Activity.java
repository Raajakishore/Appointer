package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.data.Databasehandler;
import com.example.myapplication.model.Patient;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;

public class Main3Activity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private EditText gender;
    private EditText age;
    private EditText contact;
    private EditText bloodgrp;
    private EditText address;
    private Button save;
    private Databasehandler db ;
    private Spinner myspinner;
        private Spinner mySpinner1;
        private DatePickerDialog.OnDateSetListener mdate;
        private TextView tt;
    String gen;
    String Bloodgroup;
    String DOB;
    ArrayList<String> ar;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH);
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    ArrayList<String> ar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        db=new Databasehandler(this);
//        db.de();
        Toolbar toolba = findViewById(R.id.too);
        setSupportActionBar(toolba);
        name=findViewById(R.id.name);
        myspinner = findViewById(R.id.spinner);
        mySpinner1 = findViewById(R.id.spinner1);
        password=findViewById(R.id.password);
        tt=findViewById(R.id.cal);
        contact=findViewById(R.id.contact);
        address=findViewById(R.id.address);
        save=findViewById(R.id.save);
        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(Main3Activity.this, AlertDialog.THEME_HOLO_DARK,mdate,year,month,day);
                dialog.show();

            }
        });
        mdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+ 1;
                DOB = dayOfMonth+"/"+ month + "/" + year;
          tt.setText(DOB);
          tt.setTextColor(getResources().getColor(R.color.colorAcent));
            }
        };
          ar = new ArrayList<String>();
        ar.add("male");
        ar.add("female");
        ar.add("transgender");



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.text,ar);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(arrayAdapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              gen = myspinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ar1 = new ArrayList<>();
        ar1.add("O+");
        ar1.add("O-");
        ar1.add("A+");
        ar1.add("A-");
        ar1.add("B+");
        ar1.add("B-");
        ar1.add("AB+");
        ar1.add("AB-");

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this,R.layout.text,ar1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       mySpinner1.setAdapter(arrayAdapter1);
        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Bloodgroup= mySpinner1.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("p", "onClick: " + name.getText().toString() +  password.getText().toString() + gen + contact.getText().toString() +  Bloodgroup + address.getText().toString() );
                if(!(name.getText().toString().isEmpty())&&
                   !(password.getText().toString().isEmpty())&&
                   !(gen.isEmpty())&&
                    !(contact.getText().toString().isEmpty())&&
                   !(Bloodgroup.isEmpty())&&
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

        String password1=password.getText().toString().trim();
        String gender1=gen;
        String contact1=contact.getText().toString().trim();
        String bloodgrp1=Bloodgroup;
        String address1=address.getText().toString().trim();
        patient.setUserName(contact.getText().toString());
        patient.setPatientName(name1);
        patient.setPassword(password1);
        patient.setGender(gender1);
        patient.setDob(DOB);
        patient.setContact(contact1);
        patient.setBloodgp(bloodgrp1);
        patient.setAddress(address1);

        Log.d("patientdetail", "savePatient: "+patient);
        db.addPatient(patient);
        Snackbar.make(v,"SUCCESSFULLY REGISTERED",Snackbar.LENGTH_LONG).show();

    }
}
