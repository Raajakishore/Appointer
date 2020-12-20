package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.util.RecyclerviewAdapter.Re1;

import java.util.ArrayList;

public class Specialty_frag extends Fragment {
    RecyclerView recyclerView;
    Re1 re1;
    EditText Search;
    ArrayList<Doctors> doctors = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.speciality,container,false);
        recyclerView = view.findViewById(R.id.specialty_frag_id);


        return view;
    }
}
