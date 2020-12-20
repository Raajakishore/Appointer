package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Hospital;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.tokee;
import com.example.myapplication.model.tokense;
import com.example.myapplication.util.RecyclerviewAdapter.Doctors_recycleradapter;
import com.example.myapplication.util.T;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {
TextView Hospital_name;
RecyclerView recyclerView;
tokense t = new tokense();
public  static Activity fa;
    tokense t1 = new tokense();
ArrayList<String> ti = new ArrayList();
    ArrayList<String> ti1 = new ArrayList();
Doctors_recycleradapter doctors_recycleradapter;
FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
CollectionReference cr ;
Query query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Hospital_name = findViewById(R.id.hospital_name_cardview);
        Lists lists = Lists.getInstance();
        fa  = this;
        Hospital hospital = lists.getHospital();
        cr = firebaseFirestore.collection("Hospital").document(hospital.getHospital_name()).collection("Doctors");
        Hospital_name.setText(hospital.getHospital_name());
        query = cr.orderBy("name", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Doctors> options = new FirestoreRecyclerOptions.Builder<Doctors>().setQuery(query,Doctors.class).build();
        doctors_recycleradapter = new Doctors_recycleradapter(options);
        recyclerView = findViewById(R.id.doctors_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        doctors_recycleradapter.startListening();
        recyclerView.setAdapter(doctors_recycleradapter);
        clicking();
t.setTiming("3:00PM - 4:00PM");
t.setTimeadded(2020061610400l);
t1.setTiming("9:00PM - 10:00PM");
t1.setTimeadded(2020061711000l);
ti.add("1");
ti.add("2");
ti.add("3");
ti.add("4");

        ti1.add("5");
        ti1.add("6");
        ti1.add("7");
        ti1.add("8");
t.setToke(ti);
t1.setToke(ti1);

    }

    private void clicking() {
        doctors_recycleradapter.setOnitemListener(new Doctors_recycleradapter.OnitemListener() {
            @Override
            public void onItemClick(int position) {
                Doctors doctors = doctors_recycleradapter.getItem(position);
                Lists lists= Lists.getInstance();
                lists.setDoctors(doctors);

//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document("16-06-2020").collection("tokens").document(t.getTiming()).set(t);
//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document("17-06-2020").collection("tokens").document(t1.getTiming()).set(t1);

                //                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document("10-06-2020").collection("tokens").document(t1.getTiming()).set(t1);
//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document("12-06-2020").collection("tokens").document(t.getTiming()).set(t);
//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document("11-06-2020").collection("tokens").document(t1.getTiming()).set(t1);
//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document("11-06-2020").collection("tokens").document(t.getTiming()).set(t);
//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(bundle.getString("dat")).set(t);
//                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(bundle.getString("dat")).set(t);
                startActivity(new Intent(Main5Activity.this,Main6Activity.class));

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        doctors_recycleradapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
    doctors_recycleradapter.stopListening();
    }
}
