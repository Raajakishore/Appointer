package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Patient;
import com.example.myapplication.util.Main9Activity;
import com.example.myapplication.util.constants;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.History;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Main3Activity extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private EditText gender;
    private EditText age;
    ProgressBar p;
    String email1;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser currentUser;
    private EditText contact;
    private EditText bloodbloodgrp;
    private EditText address;
    private Button save;
    TextView nami;
    TextView addresi;
    TextView citi;
    TextView phoni;
    private  EditText confirmpassword;
    Patient patient = new Patient();
    private TextView dontmatch;
    private EditText email;
    private Spinner myspinner;
    private Spinner mySpinner1;TextView ll;
    private DatePickerDialog.OnDateSetListener mdate;
   private  TextView city;
    String gen = "";
    constants cons = new constants();
    int aa=0;
    String Bloodgroup = "";

    ArrayList<String> ar;
    String incorrect;
    ImageButton getProfile_image ;
    Calendar calendar = Calendar.getInstance();
    int year = calendar.get(Calendar.YEAR);
    public static final int GALLERY_CODE= 1;
    int month = calendar.get(Calendar.MONTH);
    StorageReference storageReference;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    ArrayList<String> ar1;
    ImageButton profile_image;
    Uri Imageuri;
    FirebaseFirestore fb = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        firebaseAuth = FirebaseAuth.getInstance();
        Toolbar toolba = findViewById(R.id.too);
        setSupportActionBar(toolba);
        p = findViewById(R.id.progressbar3);
        nami = findViewById(R.id.nami);
        citi = findViewById(R.id.citi);
        addresi = findViewById(R.id.adresi);
        phoni = findViewById(R.id.phoni);
        city = findViewById(R.id.city);
        ll = findViewById(R.id.ll);
        getProfile_image = findViewById(R.id.profile_image);
        name=findViewById(R.id.name);
        myspinner = findViewById(R.id.spinner);
        mySpinner1 = findViewById(R.id.spinner1);
        password=findViewById(R.id.password);
        storageReference  = FirebaseStorage.getInstance().getReference();
p=findViewById(R.id.progressbar3);
        contact=findViewById(R.id.contact);
        address=findViewById(R.id.address);
        confirmpassword = findViewById(R.id.CONFIRMpassword);
        save=findViewById(R.id.save);
        email= findViewById(R.id.email);
        dontmatch = findViewById(R.id.dontmatch);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                currentUser = firebaseAuth.getCurrentUser();
                if(currentUser!=null){
                }else {

                }}
        };
//        deleting();


        getProfile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,GALLERY_CODE);


            }
        });
        p.setVisibility(View.INVISIBLE);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ar = new ArrayList<String>();
        ar.add("Gender");
         ar.add("male");
        ar.add("female");
        ar.add("transgender");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.text,ar){ @Override
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
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,R.layout.text,ar1){ @Override
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
                if(position>0){Bloodgroup= mySpinner1.getSelectedItem().toString();}
            else{
            Bloodgroup = "";}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//      password.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//
//          }
//      });
//        confirmpassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                }
//
//        });
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
    else if((int)ss.charAt(w)==32){

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
                    else if( (int)ss.charAt(w)==44 || (int)ss.charAt(w)==32){

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
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                p.setVisibility(View.VISIBLE);
                passwordchecking(password.getText().toString().trim(),confirmpassword.getText().toString().trim());
                Log.d("p", "onClick: " + name.getText().toString() +  password.getText().toString() + gen + contact.getText().toString() +  Bloodgroup + address.getText().toString() );
            if(  checker()>0){
                p.setVisibility(View.INVISIBLE);
            }
               else if(password.getText().toString().trim().length()<6){
                    p.setVisibility(View.INVISIBLE);
                   dontmatch.setText("Password should contain atleast 6 characters");
                }
                else if(contact.getText().toString().length()!=10){
                    p.setVisibility(View.INVISIBLE);
                    phoni.setText("Enter Correct Phone Number");
                }
                else if(!nami.getText().toString().isEmpty()|| !citi.getText().toString().isEmpty() || !phoni.getText().toString().isEmpty() || !addresi.getText().toString().isEmpty() ){
p.setVisibility(View.INVISIBLE);
                }
//                else if(email.getText().toString().trim().contains("")){
//
//                }
                else if(!(name.getText().toString().isEmpty())&&
                   !(password.getText().toString().isEmpty())&&
                   !(gen.isEmpty())&&
                    !(contact.getText().toString().isEmpty())&&
                        !(city.getText().toString().isEmpty())&&
!(email.getText().toString().isEmpty())&&
                        !(incorrect.equals("")) &&
                        !(Bloodgroup.isEmpty())&&
                   !(address.getText().toString().isEmpty())) {
                    savePatient(v);
                    Log.d("completelistener1", "onComplete: ");

                 }
                else {
                    if (incorrect.equals("")) {}
                    else {
                        p.setVisibility(View.INVISIBLE);
                        Snackbar.make(v, "Empty Fields Are Not Allowed", Snackbar.LENGTH_LONG).show();

                    }
                }
            }
        });

    }

    private int checker() {
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
        if(password.getText().toString().isEmpty()){
            password.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            password.setBackgroundResource(R.drawable.rf);
        }
        if(confirmpassword.getText().toString().isEmpty()){
            confirmpassword.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            confirmpassword.setBackgroundResource(R.drawable.rf);
        }
        if(email.getText().toString().isEmpty()){
            email.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            email.setBackgroundResource(R.drawable.rf);
        }
        if(gen.toString().isEmpty()){
            myspinner.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            myspinner.setBackgroundResource(R.drawable.rf);
        }
        if(Bloodgroup.isEmpty()){
            mySpinner1.setBackgroundResource(R.drawable.rf1);
            y=y+1;
        }
        else{
            mySpinner1.setBackgroundResource(R.drawable.rf);
        }
    return  y;}

//    private void deleting() {
//        Log.d("deletion", "deleting: ");
//        fb.collection("R-S"). document("rere").delete();
//
//
//    }

    @Override
    protected void onPause() {
        super.onPause();
        if(authStateListener!=null){
        firebaseAuth.removeAuthStateListener(authStateListener);
    }}

    void signinin(final View v){
        firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("completelistener2", "onComplete: ");
                Lists lists = Lists.getInstance();
           firebaseAuth.signInWithEmailAndPassword(email1,password.getText().toString());
                lists.setName(email1);
                lists.setPassword(password.getText().toString());
                lists.setFirebaseAuth(firebaseAuth);
                if (task.isSuccessful()) {
                    FirebaseUser user= firebaseAuth.getCurrentUser();
                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
startActivity(new Intent(Main3Activity.this, Main9Activity.class));
finish();
                        }
                    });

                    Log.d("completelistener3", "onComplete: ");
                    p.setVisibility(View.INVISIBLE);


                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                p.setVisibility(View.INVISIBLE);
                Log.d("efefef", "onFailure: " + e.toString());
                if(e.toString().contains("The email address is already in use by another account")){
                    Snackbar.make(v, "You already have an account", Snackbar.LENGTH_LONG).show();
                    new CountDownTimer(500,500){

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            startActivity(new Intent(Main3Activity.this,Main2Activity.class));
                            finish();
                        }
                    }.start();

                }
                else if(e.toString().contains("The email address is badly formatted")){
                    Snackbar.make(v, "Please enter correct Email Id", Snackbar.LENGTH_LONG).show();
                }
             else{
                    Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                }

                Log.d("failure", "onFailure: ");
            }
        });
    }
    private void passwordchecking(String trim, String trim1) {
        if(password.getText().toString().trim().equals( confirmpassword.getText().toString().trim())){
            dontmatch.setText("");
        incorrect = "no";}
        else{
            dontmatch.setText("Confirm password does not match");
            p.setVisibility(View.INVISIBLE);
            incorrect="";
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode == GALLERY_CODE && resultCode == RESULT_OK) {
           if(data!=null)
           {Imageuri = data.getData();
           getProfile_image.setImageURI(Imageuri);
               final StorageReference storage = storageReference.child("Profile_images").child("image" + Timestamp.now().getSeconds());
               storage.putFile(Imageuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                   @Override
                   public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                       storage.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                           @Override
                           public void onSuccess(Uri uri) {
                               if(uri!=null){
patient.setImageUri(uri.toString());
                               Log.d("87878987", "onSuccess: " + uri.toString());
                                   Log.d("8787878787", "onSuccess: " + patient.getImageUri());
                           }
                               else{
                               Log.d("97979797", "onFailure: ");
                           }}
                       }).addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {

                           }
                       });
                   }
               });
           super.onActivityResult(requestCode, resultCode, data);
       }    }}
    @Override
    protected void onStart() {
        super.onStart();
    currentUser = firebaseAuth.getCurrentUser();
    firebaseAuth.addAuthStateListener(authStateListener);
    }

    private void savePatient(final View v) {
        Log.d("save_patient", "savePatient: ");

        String name1 = name.getText().toString().trim();
        Map<String, Object> data = new HashMap<>();
        String password1 = password.getText().toString().trim();
        String gender1 = gen;
        String contact1 = contact.getText().toString().trim();
        String district = Bloodgroup;
          email1 = email.getText().toString().trim();
        String address1 = address.getText().toString().trim();
        constants c = new constants();

        patient.setPatientName(name1);
        patient.setPassword(password1);
        patient.setGender(gender1);
        patient.setCity(city.getText().toString().trim().toLowerCase());
        patient.setContact(contact1);
        patient.setDistrict(district);
        patient.setAddress(address1);
        patient.setEmail(email1);
        String  first_letter = Character.toString(email1.toLowerCase().charAt(0));


aa = 0;
aa = email1.toLowerCase().charAt(0);
       if(aa>96 && aa<103)
       {
       for (String letter : cons.A_F) {

            if(letter.equals(first_letter)){

            fb.collection("A-F").document(email1).collection("profile").document("profile").set(patient).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Map m = new HashMap();
                    m.put("exists","true");
                    fb.collection("A-F").document(email1).collection("Appointmnet").document("null").set(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            signinin(v);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            p.setVisibility(View.INVISIBLE);
                            Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                        }
                    });;


                }
            });

                break;}

        }

           Log.d("aacount", "savePatient: " + aa);}

    else if(aa>102 && aa<109)
       {  Log.d("aif", "savePatie: ");
         for (String letter : cons.G_L) {
            Log.d("aiffor", "savePatient: " + letter);
            if(letter.equals(first_letter)){
                Log.d("aifforif", "savePatient: ");
                fb.collection("G-L").document(email1).collection("profile").document("profile").set(patient).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Map m = new HashMap();
                        m.put("exists","true");
                        fb.collection("G-l").document(email1).collection("Appointmnet").document("null").set(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                signinin(v);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                p.setVisibility(View.INVISIBLE);
                                Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                            }
                        });;


                    }
                });

                break;


            }}
        }
        else if(aa>108 && aa<114)
        { for (String letter : cons.M_Q) {
            if(letter.equals(first_letter)){
                fb.collection("M-Q").document(email1).collection("profile").document("profile").set(patient).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Map m = new HashMap();
                        m.put("exists","true");
                        fb.collection("M-Q").document(email1).collection("Appointmnet").document("null").set(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                signinin(v);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                p.setVisibility(View.INVISIBLE);
                                Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                            }
                        });;


                    }
                });

break;
            }  ;}
        }
        else if(aa>113 && aa <116)
        { for (String letter : cons.R_S) {
            if(letter.equals(first_letter)){
                fb.collection("R-S").document(email1).collection("profile").document("profile").set(patient).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Map m = new HashMap();
                        m.put("exists","true");
                        fb.collection("R-S").document(email1).collection("Appointmnet").document("null").set(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                signinin(v);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                p.setVisibility(View.INVISIBLE);
                                Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                            }
                        });;


                    }
                });


            break;}  ;}
        }
       else if(aa> 115 && aa<123)
        { for (String letter : cons.T_Z) {
            if(letter.equals(first_letter)){
                fb.collection("T-Z").document(email1).collection("profile").document("profile").set(patient).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Map m = new HashMap();
                        m.put("exists","true");
                        fb.collection("T-Z").document(email1).collection("Appointmnet").document("null").set(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                signinin(v);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                p.setVisibility(View.INVISIBLE);
                                Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                            }
                        });;


                    }
                });


            break;}  }
        }
        else
        {
            Log.d("other", "savePatient: ");
            fb.collection("OTHER").document(email1).collection("profile").document("profile").set(patient).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                       Map m = new HashMap();
                       m.put("exists","true");
                        fb.collection("OTHER").document(email1).collection("Appointmnet").document("null").set(m).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                signinin(v);
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                p.setVisibility(View.INVISIBLE);
                                Snackbar.make(v, "Try Again", Snackbar.LENGTH_LONG).show();
                            }
                        });;


                    }
                });


            }
    }
        }
