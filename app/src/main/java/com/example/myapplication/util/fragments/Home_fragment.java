package com.example.myapplication.util.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Main4Activity;
import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.util.RecyclerviewAdapter.RecyclerViewAdapter;

import java.util.ArrayList;

public class Home_fragment extends Fragment  {
    HomeButtonselection listener;
    public RecyclerView recyclerView;
    public RecyclerViewAdapter recyclerViewAdapter;
    Button button ;
    TextView tt;
 String  a ="2";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        ArrayList<Appointmentlist> ll = new ArrayList<>();
        ll.add(new Appointmentlist("ABC HOSPITAL","12.00AM","2/1/2020"));



        recyclerView =view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter =  new RecyclerViewAdapter(getActivity(),ll);
        recyclerView.setAdapter(recyclerViewAdapter);







        return view;

    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof HomeButtonselection){
            listener= (HomeButtonselection) context;
        }
        else{
            throw new ClassCastException("HI");
        }
    }

    public interface HomeButtonselection{
        public void btnselected();

    }
}

