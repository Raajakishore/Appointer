package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Main4Activity;
import com.example.myapplication.Main8Activity;
import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.tokense;
import com.example.myapplication.util.RecyclerviewAdapter.Re;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class up1 extends Fragment {
    FirebaseFirestore c = FirebaseFirestore.getInstance();
    RecyclerView recyclerView ;
    Appointmentlist apo;
    Re re;
    Lists lists = Lists.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upcoming_frag,container,false);
        recyclerView = view.findViewById(R.id.recyc);
        Query query = c.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("upcoming").orderBy("date", Query.Direction.ASCENDING).whereEqualTo("condition", "upcoming");
        FirestoreRecyclerOptions<Appointmentlist> options = new FirestoreRecyclerOptions.Builder<Appointmentlist>().setQuery(query, Appointmentlist.class).build();
        re = new Re(options, new Re.intee() {
            @Override
            public void suff(final Appointmentlist apo) {

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
                                c.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getDoctor_name()).collection("Token").document(apo.getDate()).collection("tokens").document(apo.getTiming()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
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
                                            c.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getDoctor_name()).collection("Token").document(apo.getDate()).collection("tokens").document(apo.getTiming()).set(tok);
                                    }
                                    else{
                                        tokense tek = new tokense();
                                        tek.setTiming(apo.getTiming());
                                        tek.setTimeadded(apo.getCc());
                                        ArrayList<String> toke = new ArrayList<>();
                                        toke.add(apo.getToken().toString());
                                        tek.setToke(toke);
                                            c.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getDoctor_name()).collection("Token").document(apo.getDate()).collection("tokens").document(apo.getTiming()).set(tek);
                                    }
                                    }
                                }).addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        c.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("previous").document(apo.getTimeadded()).set(apo).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                c.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("upcoming").document(apo.getTimeadded()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
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
        return view;
    }
    @Override
    public void onStop() {
        super.onStop();
        re.startListening();
    }
    @Override
    public void onStart() {
        super.onStart();
        re.startListening();
    }
}
