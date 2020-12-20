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
import com.example.myapplication.model.Hospital;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class Re3 extends FirestoreRecyclerAdapter<Hospital,Re3.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public Re3(@NonNull FirestoreRecyclerOptions<Hospital> options) {
        super(options);
    }

    public interface  OnItemClickListener{
        void onItemClick(int position);
    }OnItemClickListener itemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        itemClickListener = onItemClickListener;
    }
    Context context;
    ArrayList<Doctors> doctors;



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_re3,parent,false);


        return new ViewHolder(view);
    }

       @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Hospital model) {
        holder.hospital_name.setText(model.getHospital_name());
    }



//    public void filterring(ArrayList<Doctors> filterresults) {
//        doctors = filterresults;
//        notifyDataSetChanged();
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView hospital_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospital_name = itemView.findViewById(R.id.namee);
       itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {if(itemClickListener != null){
               int position = getAdapterPosition();
               if(position!= RecyclerView.NO_POSITION){
               itemClickListener.onItemClick(position);}
           }}
       });

        }
    }
}
