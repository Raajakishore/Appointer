package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

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

import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.util.RecyclerviewAdapter.Re2;

import java.util.ArrayList;

public class Hospitals_frag extends Fragment {
    RecyclerView recyclerView;
    Re2 re2;
    EditText Search;
    ArrayList<Doctors> doctors = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hospitals,container,false);
        re2 = new Re2(getContext(),doctors);
        recyclerView = view.findViewById(R.id.hospitals_frag_id);
        Search = view.findViewById(R.id.search_area);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(re2);
        Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
filter(s.toString().toLowerCase().trim());
            }
        });
        return view;
    }

    private void filter(String trim) {
        ArrayList<Doctors> filterresults = new ArrayList<>();
        for (Doctors d : doctors){
        if(d.getHospital_name().toLowerCase().trim().contains(trim)){
            filterresults.add(d);
        }
    }
        re2.filterring(filterresults);
}}
