package com.example.myapplication.util.RecyclerviewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
public Context context;
public ArrayList<Appointmentlist> appointmentlists;

    public RecyclerViewAdapter(Context context, ArrayList<Appointmentlist> appointmentlists) {
        this.context = context;
        this.appointmentlists = appointmentlists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlayout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Appointmentlist lsit = appointmentlists.get(position);
        holder.hospital_name.setText(lsit.getHospital_name())
        ;
        holder.Appointmentdate.setText(lsit.getDate());
        holder.Appoinmenttime.setText(lsit.getTiming());
    }


    @Override
    public int getItemCount() {

        return appointmentlists.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
public  TextView hospital_name;
        public TextView Appointmentdate;
        public TextView Appoinmenttime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospital_name = itemView.findViewById(R.id.hospitalname);
            Appointmentdate = itemView.findViewById(R.id.Appoinmentdate);
            Appoinmenttime = itemView.findViewById(R.id.Appoinmenttime);


        }
    }
}
