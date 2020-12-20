package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Book_appointment;
import com.example.myapplication.Main5Activity;
import com.example.myapplication.Main6Activity;
import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Hospital;
import com.example.myapplication.model.Lists;
import com.example.myapplication.util.RecyclerviewAdapter.Re3;
import com.example.myapplication.util.RecyclerviewAdapter.Re4;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class Doctors_frag extends Fragment {
    ArrayList<Doctors> doctors  = new ArrayList<>();
    RecyclerView recyclerView;
    EditText Search;
    Lists lists;
    Re4 re4 ;
    View view;

    FirestoreRecyclerOptions<Doctors> options;
    Query query;
    FirebaseFirestore fb  =FirebaseFirestore.getInstance();
    CollectionReference c  = fb.collection("Doctor");
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.doctors_frag, container, false);

        query = c.orderBy("name", Query.Direction.ASCENDING);
        options = new FirestoreRecyclerOptions.Builder<Doctors>().setQuery(query, Doctors.class).build();
        recyclerView = view.findViewById(R.id.doctor_frag_id);
        re4 = new Re4(options, new Re4.inteee() {
            @Override
            public void suffe(final Doctors apo) {
                lists = Lists.getInstance();
                final Doctors doctors = new Doctors();
                fb.collection("Hospital").document(apo.getHospital_name()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        lists.setHospital(documentSnapshot.toObject(Hospital.class));
                        fb.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getName()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                lists.setDoctors(documentSnapshot.toObject(Doctors.class));
                                startActivity(new Intent(getActivity(), Main6Activity.class));
                            }
                        });

                    }
                });

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        clicking();

        Search = view.findViewById(R.id.search_area);
        Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String check = "";

                if(!(s.toString().isEmpty()))
                {
                    for(int i =0 ; i <s.toString().length(); i++){
                        if(i == 0){
                            check = String.valueOf(s.toString().charAt(0)).toUpperCase().trim();}
                        else{
                            check = check + String.valueOf(s.toString().charAt(i)).toLowerCase();
                        }
                    } query = c.orderBy("name", Query.Direction.ASCENDING).startAt(check).endAt(check + "\uf8ff");
                    options = new FirestoreRecyclerOptions.Builder<Doctors>().setQuery(query, Doctors.class).build();
                    re4 = new Re4(options, new Re4.inteee() {
                        @Override
                        public void suffe(final Doctors apo) {
                            lists = Lists.getInstance();
                            final Doctors doctors = new Doctors();
                            fb.collection("Hospital").document(apo.getHospital_name()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    lists.setHospital(documentSnapshot.toObject(Hospital.class));
                                    fb.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getName()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                                            lists.setDoctors(documentSnapshot.toObject(Doctors.class));
                                            startActivity(new Intent(getActivity(), Main6Activity.class));
                                        }
                                    });

                                }
                            });

                        }
                    });
                    recyclerView.setAdapter(re4);
                    re4.startListening();
//                    clicking();
                }
                else{
                    query = c.orderBy("name", Query.Direction.ASCENDING);
                    options = new FirestoreRecyclerOptions.Builder<Doctors>().setQuery(query, Doctors.class).build();
                    re4 = new Re4(options, new Re4.inteee() {
                        @Override
                        public void suffe(final Doctors apo) {
                            lists = Lists.getInstance();
                            final Doctors doctors = new Doctors();
                            fb.collection("Hospital").document(apo.getHospital_name()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                @Override
                                public void onSuccess(DocumentSnapshot documentSnapshot) {
                                    lists.setHospital(documentSnapshot.toObject(Hospital.class));
                                    fb.collection("Hospital").document(apo.getHospital_name()).collection("Doctors").document(apo.getName()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                        @Override
                                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                                            lists.setDoctors(documentSnapshot.toObject(Doctors.class));
                                            startActivity(new Intent(getActivity(), Main6Activity.class));
                                        }
                                    });

                                }
                            });

                        }
                    });
                    recyclerView.setAdapter(re4);
                    re4.startListening();
//                    clicking();

                }}
        });

        recyclerView.setAdapter(re4);

//Search.addTextChangedListener(new TextWatcher() {
//    @Override
//    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//    }
//
//    @Override
//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//    }
//
//    @Override
//    public void afterTextChanged(Editable s) {
//filter(s.toString());
//    }
//});
        return view;
//    }
//
//    private void filter(String toString) {
//        ArrayList<Doctors> filterresults = new ArrayList<>();
//        for(Doctors d: doctors){
//            if(d.getName().toUpperCase().trim().contains(toString.toUpperCase().trim())){
//                filterresults.add(d);
//            }
//            else{
//
//            }
//        }
//        re4.filterdList(filterresults);
    }
//    private void clicking() {
//        re4.su(new Re3.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
////        Doctors docm = doctors.get(position);
//                Hospital hospital =    re3.getItem(position);
//                Lists lists = Lists.getInstance();
//                lists.setHospital(hospital);
//                Intent intent  = new Intent(getActivity(), Main5Activity.class);
////        Bundle bundle = new Bundle();
//
////        bundle.putString("doctors",docm.getName());
////        bundle.putString("clinics_name",docm.getHospital_name());
//                startActivity(intent);
//            }
//        });
//    }
    @Override
    public void onStart() {
        super.onStart();
        re4.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        re4.stopListening();
    }
}
