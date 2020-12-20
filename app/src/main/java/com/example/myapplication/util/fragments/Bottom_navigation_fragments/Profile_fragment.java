package com.example.myapplication.util.fragments.Bottom_navigation_fragments;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Patient;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Profile_fragment extends Fragment {
    FirebaseFirestore fb = FirebaseFirestore.getInstance();
    Lists lists = Lists.getInstance();
    Patient patient;
    ImageButton imageButton;
    private EditText name;
    ArrayList<String> ar;
    private EditText gender;
    ProgressBar p;
    private EditText contact;
    TextView nami;TextView phoni; TextView addresi;TextView citi;
    private EditText district;
    String gen ="";
    String District;
    ArrayList<String> ar1;
    private EditText address;
    private Button save;
    private Spinner myspinner;
    private Spinner mySpinner1;
    private TextView city;
    utii et;
    ImageButton getProfile_image ;

    public Profile_fragment(utii ut) {
    et = ut;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.book,container,false);
        city = view.findViewById(R.id.city);
        getProfile_image = view.findViewById(R.id.profile_image);
        name=view.findViewById(R.id.name);
        nami = view.findViewById(R.id.nami);addresi = view.findViewById(R.id.adresi);phoni = view.findViewById(R.id.phoni);citi = view.findViewById(R.id.citi);
        myspinner = view.findViewById(R.id.spinner);p = view.findViewById(R.id.progressBar3);p.setVisibility(View.INVISIBLE);
        mySpinner1 = view.findViewById(R.id.spinner1);
        save = view.findViewById(R.id.save);
        imageButton = view.findViewById(R.id.profile_image);
       StorageReference storageReference  = FirebaseStorage.getInstance().getReference();
        ar = new ArrayList<String>();
        ar.add("Gender");
        ar.add("male");
        ar.add("female");
        ar.add("transgender");
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.text,ar){ @Override
        public boolean isEnabled(int position){
            if(position == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
//                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(arrayAdapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){gen = myspinner.getSelectedItem().toString();}
                else{gen = "" ;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        ar1 = new ArrayList<>();
        ar1.add("District");
        ar1.add("Ariyalur");
        ar1.add("Chengalpattu");
        ar1.add("Chennai");
        ar1.add("Coimbatore");
        ar1.add("Cuddalore");
        ar1.add("Dharmapuri");
        ar1.add("Dindigul");
        ar1.add("Erode");
        ar1.add("Kallakurichi");
        ar1.add("Kanchipuram");
        ar1.add("Kanyakumari");
        ar1.add("Karur");
        ar1.add("Krishnagiri");
        ar1.add("Madurai");
        ar1.add("Mayiladuthurai");
        ar1.add("Nagapattinam");
        ar1.add("Namakkal");
        ar1.add("Nilgiris");
        ar1.add("Perambalur");
        ar1.add("Pudukkottai");
        ar1.add("Ramanathapuram");
        ar1.add("Ranipet");
        ar1.add("Salem");
        ar1.add("Sivagangai");
        ar1.add("Tenkasi");
        ar1.add("Thanjavur");
        ar1.add("Theni");
        ar1.add("Thoothukudi");
        ar1.add("Tiruchirappalli");
        ar1.add("Tirunelveli");
        ar1.add("Tirupattur");
        ar1.add("Tiruppur");
        ar1.add("Tiruvallur");
        ar1.add("Tiruvannamalai");
        ar1.add("Tiruvarur");
        ar1.add("Vellore");
        ar1.add("Viluppuram");
        ar1.add("Virudhunagar");
        final ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getContext(),R.layout.text,ar1){ @Override
        public boolean isEnabled(int position){
            if(position == 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
//                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(arrayAdapter1);
        mySpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0){District= mySpinner1.getSelectedItem().toString();}
                else{
                    District = "";}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        contact=view.findViewById(R.id.contact);
        address=view.findViewById(R.id.address);
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = s.toString();
                int kk =0 ;
                for(int w=0; w<s.toString().length();w++){
                    if((((int)ss.charAt(w)>64) && ((int)ss.charAt(w)<91))){

                    }
                    else if((((int)ss.charAt(w)>96) && ((int)ss.charAt(w)<123))){

                    }
                    else{
                        kk = kk+1;

                    }
                    if(kk>0){
                        nami.setText("Are you sure you have entered your name correctly?");
                    }
                    else{
                        nami.setText("");
                    }
                }
            }
        });
        city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = s.toString();
                int kk =0 ;
                for(int w=0; w<s.toString().length();w++){
                    if((((int)ss.charAt(w)>64) && ((int)ss.charAt(w)<91))){

                    }
                    else if((((int)ss.charAt(w)>96) && ((int)ss.charAt(w)<123))){

                    }
                    else{
                        kk = kk+1;

                    }
                    if(kk>0){
                        citi.setText("Special Characters are not allowed");
                    }
                    else{
                        citi.setText("");
                    }
                }
            }
        });
        contact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String w = s.toString();
                int oo=0;
                for(int ww=0; ww<s.toString().length();ww++){
                    if((int)w.charAt(ww)>47 && (int)w.charAt(ww)<58){

                    }
                    else{

                        oo = oo+1;
                    }
                    if(oo>0){
                        phoni.setText("Special characters are not allowed");
                    }
                    else{
                        phoni.setText("");
                    }
                }
            }
        });
        address.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ss = s.toString();
                int kk =0 ;
                for(int w=0; w<s.toString().length();w++){
                    if((((int)ss.charAt(w)>64) && ((int)ss.charAt(w)<91))){

                    }
                    else if((((int)ss.charAt(w)>96) && ((int)ss.charAt(w)<123))){

                    }
                    else if( (int)ss.charAt(w)==44){

                    }
                else if((int)ss.charAt(w)>47 && (int)ss.charAt(w)<58){

                    }
                    else{
                        kk=kk+1;
                    }
                    if(kk>0){
                        addresi.setText("Special Characters are not allowed");
                    }
                    else{
                        addresi.setText("");
                    }
                }
            }
        });
        fb.collection(lists.getCAPITALS()).document(lists.getName()).collection("profile").document("profile").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
         patient = documentSnapshot.toObject(Patient.class);
                Log.d("737373", "onSuccess: " + patient.getImageUri());
         city.setText(documentSnapshot.get("city").toString());
         name.setText(patient.getPatientName());
         address.setText(patient.getAddress());
                Log.d("pppppppp", "onSuccess: " + patient.getImageUri());
         if(patient.getImageUri()!=null){
             Log.d("84848484", "onSuccess: " + patient.getImageUri());
                Picasso.get().load(Uri.parse(patient.getImageUri())).into(imageButton);}
contact.setText(patient.getContact());
myspinner.setSelection(arrayAdapter.getPosition(patient.getGender()));
mySpinner1.setSelection(arrayAdapter1.getPosition(documentSnapshot.get("district").toString()));
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setVisibility(View.VISIBLE);
                if(  checker()>0){
                    p.setVisibility(View.INVISIBLE);
                }
                 else  if(contact.getText().toString().length()!=10){
                    p.setVisibility(View.INVISIBLE);
                    phoni.setText("Enter Correct Phone Number");
                }
                   else if(!nami.getText().toString().isEmpty()|| !citi.getText().toString().isEmpty() || !phoni.getText().toString().isEmpty() || !addresi.getText().toString().isEmpty() ){
                       p.setVisibility(View.INVISIBLE);
                   }
               else if(!name.getText().toString().isEmpty() && !city.getText().toString().isEmpty() && !address.getText().toString().isEmpty() && !contact.getText().toString().isEmpty() && !gen.equals("") && !District.equals(""))
                {
                    Patient pp = new Patient();
                    pp.setDistrict(District);
                    pp.setGender(gen);
                    pp.setPatientName(name.getText().toString().trim().toLowerCase());
                    pp.setAddress(address.getText().toString().trim().toLowerCase());

pp.setContact(contact.getText().toString().trim().toLowerCase());
pp.setCity(city.getText().toString().trim().toLowerCase());
            et.frg(pp,v);
                    p.setVisibility(View.INVISIBLE);
            }
            else{
                    Snackbar.make(v, "Empty Fields Are Not Allowed", Snackbar.LENGTH_LONG).show();
            }
            }
        });
        return view;
    }    private int checker() {
        int y =0;
        if(name.getText().toString().isEmpty()){
            name.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            name.setBackgroundResource(R.drawable.rf);
        }
        if(address.getText().toString().isEmpty()){
            address.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            address.setBackgroundResource(R.drawable.rf);
        }
        if(city.getText().toString().isEmpty()){
            city.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            city.setBackgroundResource(R.drawable.rf);
        }
        if(contact.getText().toString().isEmpty()){
            contact.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            contact.setBackgroundResource(R.drawable.rf);
        }

        if(gen.toString().isEmpty()){
            myspinner.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            myspinner.setBackgroundResource(R.drawable.rf);
        }


        return  y;}
    public interface utii{
        void frg(Patient pp,View v);
    }
}
