package com.example.myapplication.util.fragments.Bottom_navigation_fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.Main4Activity;
import com.example.myapplication.R;
import com.example.myapplication.ui.main.SectionsPagerAdapter;
import com.example.myapplication.ui.main.SectionsPagerAdaptere;
import com.google.android.material.tabs.TabLayout;

public class History extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change,container,false);
        SectionsPagerAdaptere sectionsPagerAdapter = new SectionsPagerAdaptere(getContext(), getActivity().getSupportFragmentManager());
        ViewPager viewPagere = view.findViewById(R.id.view_pagere);
        viewPagere.setAdapter(sectionsPagerAdapter);
        TabLayout tabse = view.findViewById(R.id.tabse);
        Log.d("02020202029", "onCreateView: "  );
        tabse.setupWithViewPager(viewPagere);
        return view;
    }


}
