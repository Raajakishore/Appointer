package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Lists;
import com.example.myapplication.util.RecyclerviewAdapter.Re;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Appointments.no_book_appointment_fragment;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Empty;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Nulle;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class Previous_frag extends Fragment {
    FirebaseFirestore c = FirebaseFirestore.getInstance();
    RecyclerView recyclerView ;
    Re re;
    pp1 pp =new pp1();
    int i =0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.previous_frag,container,false);
        Lists lists = Lists.getInstance();
        getChildFragmentManager().beginTransaction().replace(R.id.prevee,new Nulle()).commit();
        c.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("previous").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                i = queryDocumentSnapshots.size();
                sttingrecyclerview();
            }
        });
        Log.d("53535353", "onCreateView: "+  lists.getCAPITALS() + lists.getName() );

        return view;
    }
    private void sttingrecyclerview() {
        if (i > 0) {

            getChildFragmentManager().beginTransaction().replace(R.id.prevee,pp).commit();
        }
        else {
            getChildFragmentManager().beginTransaction().replace(R.id.prevee,new no_book_appointment_fragment()).commit();
        }


    }}
