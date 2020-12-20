package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Appointments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Main4Activity;
import com.example.myapplication.Main8Activity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Hospital;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.tokense;
import com.example.myapplication.util.RecyclerviewAdapter.Re;
import com.example.myapplication.util.constants;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class  Appointment_fragment extends Fragment {
   public RecyclerView recyclerView;
   Lists lists = Lists.getInstance();
    ArrayList<Appointmentlist> appointmentlists = new ArrayList<>();
FirebaseFirestore fb = FirebaseFirestore.getInstance();
int cc =0;
String abc="";
Query query;
therii th;
    Appointmentlist app;
CollectionReference c ;

    public Re re ;
    public Appointment_fragment(therii Moodu){
        th = Moodu;
    }
    public interface therii {
        void moodui(int cc);
    }
    @Nullable
    @Override


    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        c =      fb.collection(Lists.getInstance().getAbc()).document(Lists.getInstance().getName()).collection("Appointmnet");

        View view = inflater.inflate(R.layout.appointment_fragment,container,false);
        recyclerView = view.findViewById(R.id.recycler_view_appointment);
setting();
finalizing();
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        setting();
        finalizing();
        re.startListening();
    }

public int setting(){

    c =      fb.collection(Lists.getInstance().getAbc()).document(Lists.getInstance().getName()).collection("Appointmnet");
    c.document("bookings").collection("upcoming").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
        @Override
        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
            if (queryDocumentSnapshots != null){
                for(final DocumentSnapshot documentSnapshot:queryDocumentSnapshots){
                    app =    documentSnapshot.toObject(Appointmentlist.class);
                    String as = app.getDate();
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
                    Log.d("2222222222", "onSuccess: " + c1);
                    if(app.getCc()< c1){
                        app.setCondition("previous");
                        c.document("bookings").collection("previous").document(app.getTimeadded()).set(app).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                c.document("bookings").collection("upcoming").document(app.getTimeadded()).delete();
                            }
                        });

                    }
                    else{
                        Log.d("43434343", "onSuccess: ");
                        cc =1;


                    }
                }
th.moodui(cc);
            }
        }
    });
    return  cc;
}

    private void finalizing() {

        query = c.document("bookings").collection("upcoming").orderBy("date"  , Query.Direction.DESCENDING).whereEqualTo("condition","upcoming") .limit(3);
        FirestoreRecyclerOptions<Appointmentlist> options =new FirestoreRecyclerOptions.Builder<Appointmentlist>().setQuery(query,Appointmentlist.class).build();
        re =  new Re(options, new Re.intee() {
            @Override
            public void suff(final Appointmentlist apo) {
//                startActivity(new Intent(getActivity(), Main8Activity.class));
                new AlertDialog.Builder(getContext())
                        .setIcon(R.drawable.ic_report_problem_black_24dp)
                        .setTitle("Cancel Appointment")
                        .setMessage("Are you sure you want to cancel the appointment?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                               apo.setCondition("previous");
                                apo.setConfirmed("Cancelled");
                                fb.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getDoctor_name()).collection("Token").document(apo.getDate()).collection("tokens").document(apo.getTiming()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        if(documentSnapshot.exists()){
                                        tokense tok = new tokense();
                                        tok.setTimeadded((Long) documentSnapshot.get("timeadded"));
                                        tok.setToke((ArrayList<String>) documentSnapshot.get("toke"));
                                        tok.setTiming(documentSnapshot.get("timing").toString());
                                        int arr[] = new int[tok.getToke().size()+1];
                                        ArrayList<String> ari = tok.getToke();
                                        ArrayList<String> are = new ArrayList<>();
                                        int teken = Integer.parseInt(apo.getToken());
                                        for(int i=0;i<ari.size();i++){
                                            arr[i] = Integer.parseInt(ari.get(i));
                                        }
                                        for(int i=0;i<ari.size()+1;i++){
                                            Log.d("[l[l[l", "onSuccess: " + teken + arr[i]);
                                             if(i==0 && teken<arr[i]){
                                                for(int j= arr.length-1;j>0;j--){
                                                    Log.d("trtrtr", "onSuccess: " + arr.length + arr[j]);
                                                    arr[j] = arr[j-1];
                                                }
                                                arr[0] = teken;
                                                 Log.d("trtrtr", "onSuccess: " + arr.length + arr[0]);
                                                break;
                                            }

                                            else if(i==ari.size()-1 ){
                                                 Log.d("ikikik", "onSuccess: ");
                                                arr[i+1] = teken;
                                                break;
                                            }
                                           else if(arr[i]<teken && teken<arr[i+1] ){
                                                 Log.d("kikiki", "onSuccess: ");
                                                for(int j= arr.length-1;j>i;j--){
                                                    arr[j] = arr[j-1];
                                                }
                                                arr[i+1] = teken;
                                                break;
                                            }
                                            Log.d("ghghghgh", "onSuccess: ");
                                        }
                                        for(int k = 0 ;k<arr.length;k++){
                                            are.add(String.valueOf(arr[k]));
                                        }
                                        tok.setToke(are);
                                            fb.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getDoctor_name()).collection("Token").document(apo.getDate()).collection("tokens").document(apo.getTiming()).set(tok);
                                    }
                                    else{
                                        tokense tek = new tokense();
                                        tek.setTiming(apo.getTiming());
                                        tek.setTimeadded(apo.getCc());
                                        ArrayList<String> toke = new ArrayList<>();
                                        toke.add(apo.getToken().toString());
                                        tek.setToke(toke);
                                            fb.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getDoctor_name()).collection("Token").document(apo.getDate()).collection("tokens").document(apo.getTiming()).set(tek);
                                    }
                                    }
                                }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        fb.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("previous").document(apo.getTimeadded()).set(apo).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                fb.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("upcoming").document(apo.getTimeadded()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Main4Activity.fa.finish();
                                                        startActivity(new Intent(getActivity(), Main4Activity.class));

                                                    }
                                                });
                                            }
                                        });
                                    }
                                });



                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        Log.d("start_Listening", "onCreateView: ");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(re);
        re.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        re.startListening();
    }
}
