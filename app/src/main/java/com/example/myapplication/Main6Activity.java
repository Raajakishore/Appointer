package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Tokene;
import com.example.myapplication.model.tokee;
import com.example.myapplication.model.tokense;
import com.example.myapplication.util.T;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Empty;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Nulle;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Token_available;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Object;


import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class Main6Activity extends AppCompatActivity {
    TextView name;
    TextView department;
    String Token_timing;
    TextView rating;
    String tim;
    String tii;
    Calendar  dateii ;
    long low;
    public  static Activity fa;
    Calendar dt;
    int kiko = 0;
    String ai = "";
    Token_available token_available ;
    Spinner spinner;
    String datee;
    Lists lists;
    Doctors doctors;
    TextView next;
    String[] Token   = new String[1000];
    RatingBar ratingBar;
    ArrayList EmptyKaro = new ArrayList();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    Map<String,String[]> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        lists = Lists.getInstance();
        doctors = lists.getDoctors();
        name = findViewById(R.id.doctors_named);
//        next =findViewById(R.id.next);
        department = findViewById(R.id.department_nameed);
        rating = findViewById(R.id.ratingd);
        ratingBar = findViewById(R.id.doctors_starsd);
        name.setText(doctors.getName());
        fa = this;
        department.setText(doctors.getDepartment());
        rating.setText(doctors.getStars());
        ratingBar.setRating(Float.parseFloat(doctors.getStars()));
        spinner = findViewById(R.id.timing_token);
        Calendar startDate = Calendar.getInstance();


        Log.d("444444444", "onCreate: " + startDate.get(Calendar.DAY_OF_MONTH));
        getSupportFragmentManager().beginTransaction().add(R.id.token, new Empty()).commit();
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
        final Calendar dat = Calendar.getInstance();
        dat.add(Calendar.MONTH,1);
        dt = dat;
        Log.d("dattttttteeee", "onCreate: " + dat);
        settt(dat);
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                date.add(Calendar.MONTH,1);
                if(date.get(Calendar.DAY_OF_MONTH) == dat.get(Calendar.DAY_OF_MONTH)){
                    settt(date);
                }
                else if(!date.before(dat) ){

                    dt = date;
                    settt(date);

                }
                else {
                    map.clear();
                    getSupportFragmentManager().beginTransaction().replace(R.id.token,new Empty()).commit();

                }
            }
        });

    }
    void   settt(final Calendar datei){
        kiko = 0;
        setter();
        int m = datei.get(Calendar.MONTH);
        int d= datei.get(Calendar.DAY_OF_MONTH);
        dateii = datei;

        if(m<10){
            datee = datei.get(Calendar.DAY_OF_MONTH) + "-" + "0" + String.valueOf(m) + "-" + datei.get(Calendar.YEAR);}
        else{
            datee = datei.get(Calendar.DAY_OF_MONTH) + "-" +String.valueOf(m) + "-" + datei.get(Calendar.YEAR);
        }
        if(d<10){
            datee = "0"+datee;
        }
        firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(datee).collection("tokens").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Log.d("deteee", "onSuccess: " + datee);
                if (queryDocumentSnapshots!=null){

                    for (DocumentSnapshot documentSnapshot:queryDocumentSnapshots){
                        Log.d("hhhhhhhhh", "onSuccess: "+ documentSnapshot.toString());
                        tokense tok = new tokense();
                        tok.setTiming(documentSnapshot.get("timing").toString());
                        tok.setTimeadded(documentSnapshot.getLong("timeadded"));
                        tok.setToke((ArrayList<String>) documentSnapshot.get("toke"));
                        Calendar cat = Calendar.getInstance();
                        String io = "";
                        String ip = "";
                        String ih = "";
                        String im = "";
                        if(cat.get(Calendar.MONTH)+1 <10){
                            cat.add(Calendar.MONTH,1);
                            io = "0" + cat.get(Calendar.MONTH);}
                        else {
                            io = "" + cat.get(Calendar.MONTH);
                        }
                        Log.d("333333331", "onSuccess: " + io);
                        if(cat.get(Calendar.DAY_OF_MONTH)<10){
                            ip = "0" + cat.get(Calendar.DAY_OF_MONTH);
                        }
                        else {
                            ip = "" + cat.get(Calendar.DAY_OF_MONTH);
                        }
                        if(cat.get(Calendar.HOUR) <10){
                            ih = "0" + cat.get(Calendar.HOUR);}
                        else {
                            ih = "" + cat.get(Calendar.HOUR);
                        }
                        if(cat.get(Calendar.MINUTE) <10){
                            im = "0" + cat.get(Calendar.MINUTE);}
                        else {
                            im = "" + cat.get(Calendar.MINUTE);
                        }
                        Log.d("333333332", "onSuccess: " + ip);

                        long c1 = Long.parseLong(String.valueOf(cat.get(Calendar.YEAR)) + io +ip + String.valueOf(cat.get(Calendar.AM_PM)) + ih + im);
                        if(tok.getTimeadded()<c1){
                            firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(datee).collection("tokens").document(tok.getTiming()).delete();
                            Log.d("585858585581", "onSuccess: ");
                        }
                        else if(tok.getToke().size()==0){
                            firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(datee).collection("tokens").document(tok.getTiming()).delete();
                            Log.d("585858585581", "onSuccess: ");
                        }
                    }
                }
            }
        }).addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                Log.d("0258963", "onDateSelected: " + datee);
                firebaseFirestore.collection("Hospital").document(lists.getHospital().getHospital_name()).collection("Doctors").document(doctors.getName()).collection("Token").document(datee).collection("tokens").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(DocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                            tokense tok = new tokense();
                            tok.setTiming(documentSnapshot.get("timing").toString());
                            tok.setTimeadded(documentSnapshot.getLong("timeadded"));
                            tok.setToke((ArrayList<String>) documentSnapshot.get("toke"));
                            ArrayList aa1 = (ArrayList)tok.getToke();
                            if(aa1.size()!=0){
                                saving(tok.getTiming(),aa1);
                            }
                        }
                        if(kiko==0){
                            getSupportFragmentManager().beginTransaction().replace(R.id.token,new Empty()).commit();
                        }
                    }
                });
            }
        });


    }

    void setter(){
        map.clear();
        ArrayList ar = new ArrayList();
        Log.d("Arraylist", "arranging: " +  ar.size());
        ArrayAdapter<String> arr = new ArrayAdapter<>(this,R.layout.text2,ar);
//    arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arr);
    }



    private void setgridview(String schedule) {
        String[] ae = map.get(schedule);
        if(ae.length!=0){
            token_available = new Token_available(ae, new Token_available.setonitemclicklistener()  {
                @SuppressLint("ResourceAsColor")
                @Override
                public void click(String aaw) {

                    Log.d("bbbbbbbb", "click: " );
                    Intent intent = new Intent(Main6Activity.this, Main7Activity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Token",aaw);
                    bundle.putString("doc",doctors.getName());
                    bundle.putString("hospital",lists.getHospital().getHospital_name().trim());
                    bundle.putString("dep",doctors.getDepartment());
                    for(int ii=0;ii<tim.length();ii++){
                        if(tim.charAt(ii) == ' ' && tim.charAt(ii-1) == '-'){
                            String sub = tim.substring(ii+1);
                            tii =      finding(sub);
                        }
                    }
                    String io = "";
                    String ip = "";
                    if(dateii.get(Calendar.MONTH)<10){
                        io = "0" + dateii.get(Calendar.MONTH);}
                    else {
                        io = "" + dateii.get(Calendar.MONTH);
                    }
                    if(dateii.get(Calendar.DAY_OF_MONTH)<10){
                        ip = "0" + dateii.get(Calendar.DAY_OF_MONTH);
                    }
                    else {
                        ip = "" + dateii.get(Calendar.DAY_OF_MONTH);
                    }
                    low = Long.parseLong(String.valueOf(dateii.get(Calendar.YEAR)) + io +ip + String.valueOf(dateii.get(Calendar.AM_PM))+ tii);
                    bundle.putLong("timekaro",low);

                    bundle.putString("dat",datee);
                    bundle.putString("tim",tim);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }
            });
            getSupportFragmentManager().beginTransaction().replace(R.id.token,token_available).commit();}
        else{
            getSupportFragmentManager().beginTransaction().replace(R.id.token,new Empty()).commit();}

    }

    private String finding(String sub) {
        ai="";
        if(sub.length()== 7){
            if(sub.charAt(5) == 'P'){
                dateii.set(Calendar.AM_PM,Calendar.PM);
            }
            if(sub.charAt(5) == 'A'){
                dateii.set(Calendar.AM_PM,Calendar.AM);
            }
            if(sub.charAt(0) == '1' && sub.charAt(1) == '2')
            {
                String subi = "00" + sub.substring(2);
                sub = subi;
            }
            for(int kik=0; kik<sub.length();kik++){
                if(kik == 0|| kik == 1 ||kik ==  3 || kik ==4){
                    ai = ai + String.valueOf(sub.charAt(kik));
                }
            }
        }
        if(sub.length() == 6){
            ai="0";
            if(sub.charAt(4) == 'P'){
                dateii.set(Calendar.AM_PM,Calendar.PM);
            }
            if(sub.charAt(4) == 'A'){
                dateii.set(Calendar.AM_PM,Calendar.AM);
            }
            for(int kik=0; kik<sub.length();kik++){
                if(kik == 0|| kik == 2 ||kik ==  3 ){
                    ai = ai + String.valueOf(sub.charAt(kik));
                }
            }
        }
        return ai;
    }


    private void saving(String timing, ArrayList Tokeni) {
        Log.d("saving", "saving: " + Tokeni.size());
        Log.d("saving1", "saving1: " + timing);
        String[] token = new String[Tokeni.size()];
        for(int i =0; i<Tokeni.size();i++){
            token[i] = Tokeni.get(i).toString();
        }
        map.put(timing,token);
        kiko = kiko+1;
        Log.d("saving3", "saving3: " + kiko);
        setter1();
    }

    private void setter1() {
        ArrayList ar = new ArrayList();
        ar.addAll(map.keySet());
        Log.d("Arraylist", "arranging: " +  ar.size());
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.text2,ar);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String schedule = spinner.getSelectedItem().toString();
                setgridview(schedule);
                tim = schedule;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        if(kiko == 0){
            getSupportFragmentManager().beginTransaction().replace(R.id.token,new Empty()).commit();
        }
    }

}
