package com.example.myapplication.util.fragments.Bottom_navigation_fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Main7Activity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Token_available extends Fragment {
    GridView gridView;
    TextView textView;
    String[] ae;
    ArrayList aa = new ArrayList();
    public setonitemclicklistener ss;
    public Token_available(String[] ae) {
        this.ae =ae;
    }

    public Token_available(setonitemclicklistener ss) {
        this.ss = ss;
    }
    public Token_available(String[] ae,setonitemclicklistener ss) {
        this.ss = ss;
        this.ae =ae;
    }

    public interface setonitemclicklistener{
        void click(String aaw);
}
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.token_frag,container,false);
        gridView = view.findViewById(R.id.grid_view);
        for(int i=0;i<ae.length;i++){
            aa.add("Token" + "-" +ae[i]);
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),R.layout.text1,R.id.textView5,aa);
        gridView.setAdapter(arrayAdapter);
gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String aaw = ae[position];
        Log.d("helpkaro", "onItemClick: " + position);
        if(ss!=null){
            ss.click(aaw);
        }
    }
});
        return view;

    }}
