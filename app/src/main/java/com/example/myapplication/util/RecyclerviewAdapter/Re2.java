package com.example.myapplication.util.RecyclerviewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;

import java.util.ArrayList;

public class Re2 extends RecyclerView.Adapter<Re2.ViewHolder> {
    Context context;
    ArrayList<Doctors> doctors;
public Re2(Context context, ArrayList<Doctors> doctors){
    this.context = context;
    this.doctors = doctors;
}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_re2,parent,false);

    return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.hospital_name.setText(doctors.get(position).getHospital_name());

    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public void filterring(ArrayList<Doctors> filterresults) {
    doctors = filterresults;
    notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital_name;
        TextView no_of_depts;
        TextView no_of_docs;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospital_name = itemView.findViewById(R.id.namee);
            no_of_depts = itemView.findViewById(R.id.number_of_departments);
            no_of_docs = itemView.findViewById(R.id.number_of_doctors);
        }
    }
}
