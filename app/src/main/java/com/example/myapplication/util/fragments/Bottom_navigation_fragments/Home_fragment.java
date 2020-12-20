package com.example.myapplication.util.fragments.Bottom_navigation_fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Main4Activity;
import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;
import com.example.myapplication.model.Lists;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Appointments.Appointment_fragment;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Appointments.no_book_appointment_fragment;

import java.util.ArrayList;

public class Home_fragment extends Fragment implements View.OnClickListener, Appointment_fragment.therii {
     public RecyclerView recyclerView;
    ArrayList<Doctors> doctors = new ArrayList<>();
    int cc;
    no_book_appointment_fragment noBookAppointmentFragment = new no_book_appointment_fragment();

     Button book_appointment;
    TextView viewall;
    Toolbar tool;
    onbuttonclk on;
    onclickkaro onn;
    Main4Activity main4Activity = new Main4Activity();
    int a=0;
    Appointment_fragment appointment_fragmen;
    @Override
    public void moodui(int cc) {

    }


    //    Button button ;
//    TextView tt;
// String  a ="2";
public interface onclickkaro{
    void karo();
    }
    public Home_fragment(onclickkaro onclickaro){
    onn = onclickaro;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         appointment_fragmen = new Appointment_fragment(new Appointment_fragment.therii() {
                @Override
            public void moodui(int c) {
                    if(c>0){
                cc = c;
                getChildFragmentManager().beginTransaction().replace(R.id.frame_appointment,appointment_fragmen).commit();
            }
                else{
                        FragmentManager  fragmentManager = getChildFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.frame_appointment,noBookAppointmentFragment).commit();
                }
                }
        });
        appointment_fragmen.setting();
    View view = inflater.inflate(R.layout.home_fragment,container,false);
getChildFragmentManager().beginTransaction().add(R.id.frame_appointment,new Nulle()).commit();

        Log.d("232323", "onCreateView: " +Lists.getInstance().getCc() );
//        if(appointment_fragmen.setting()!=0){
//            Log.d("appointment_frag", "onViewCreated: ");
//
//        }
//        else{
//            fragmentManager.beginTransaction().add(R.id.frame_appointment,noBookAppointmentFragment).commit();
//        }


        Lists lists = Lists.getInstance();
        book_appointment = view.findViewById(R.id.book_appointment);
        tool = view.findViewById(R.id.too);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tool);
        viewall = view.findViewById(R.id.viewall);
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onn!=null){
                    onn.karo();
                }

            }
        });



//        recyclerView =view.findViewById(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerViewAdapter =  new RecyclerViewAdapter(getActivity(),doctors);
//        recyclerView.setAdapter(recyclerViewAdapter);
        book_appointment.setOnClickListener(this);






        return view;}


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(!(context instanceof onbuttonclk)){
throw  new ClassCastException("Class is not found");
        }
        else {
            on = (onbuttonclk) context;
        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.book_appointment:
   on.click(R.id.book_appointment);
}
    }

    public interface onbuttonclk{
        void click(int id);
    }
}



