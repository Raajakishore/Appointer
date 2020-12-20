package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Main5Activity;
import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Hospital;
import com.example.myapplication.model.Lists;
import com.example.myapplication.util.RecyclerviewAdapter.Re3;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.Collection;

public class Clinics_frag extends Fragment {
    RecyclerView recyclerView;
    EditText Search;
    Re3 re3 ;
    Spinner district;
    Query query;
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    CollectionReference c = firebaseFirestore.collection("Hospital");
    FirestoreRecyclerOptions<Hospital> options;
    View view;
    int a=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
 view = inflater.inflate(R.layout.clinics,container,false);
recyclerView = view.findViewById(R.id.clinics_frag_id);
query = c.orderBy("Hospital_name", Query.Direction.ASCENDING).startAt("").endAt("uf8ff");
//district = view.findViewById(R.id.district_spinner);
 options =new FirestoreRecyclerOptions.Builder<Hospital>().setQuery(query,Hospital.class).build();
 re3 = new Re3(options);
re3.startListening();
recyclerView.setHasFixedSize(true);
recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
recyclerView.setAdapter(re3);
clicking();

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
            }query = c.orderBy("Hospital_name", Query.Direction.ASCENDING).startAt(check).endAt(check + "\uf8ff");
        FirestoreRecyclerOptions<Hospital> options =new FirestoreRecyclerOptions.Builder<Hospital>().setQuery(query,Hospital.class).build();
            re3 = new Re3(options);
        recyclerView.setAdapter(re3);
            re3.startListening();
            clicking();
    }
    else{
            query = c.orderBy("Hospital_name", Query.Direction.ASCENDING);
            options =new FirestoreRecyclerOptions.Builder<Hospital>().setQuery(query,Hospital.class).build();
            re3 = new Re3(options);
            recyclerView.setAdapter(re3);
            re3.startListening();
            clicking();

        }}
});

        return view;
//    }
//
//    private void filter(String trim) {
//        ArrayList<Doctors> filterresults = new ArrayList<>();
//        for(Doctors d: doctors){
//             if(d.getHospital_name().toLowerCase().trim().contains(trim)){
//                 filterresults.add(d);
//             }
//         }
//        re3.filterring(filterresults);
    }

    private void clicking() {
        re3.setOnItemClickListener(new Re3.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//        Doctors docm = doctors.get(position);
             Hospital hospital =    re3.getItem(position);
                Lists lists = Lists.getInstance();
                lists.setHospital(hospital);
                Intent intent  = new Intent(getActivity(), Main5Activity.class);
//        Bundle bundle = new Bundle();

//        bundle.putString("doctors",docm.getName());
//        bundle.putString("clinics_name",docm.getHospital_name());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        re3.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
    re3.stopListening();
    }
}
