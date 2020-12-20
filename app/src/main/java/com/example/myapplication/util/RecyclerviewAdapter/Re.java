package com.example.myapplication.util.RecyclerviewAdapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Hospital;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import java.util.ArrayList;

public class Re extends FirestoreRecyclerAdapter<Appointmentlist,Re.ViewHolder> {
intee ee;

    Appointmentlist apo ;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public Re(@NonNull FirestoreRecyclerOptions<Appointmentlist> options,intee i) {
        super(options);
        ee = i;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout_appointment,parent,false);
        Log.d("create_is_working", "onBindViewHolder: ");
        return new ViewHolder(view);
    }
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Appointmentlist model) {

        Log.d("model_is_working", "onBindViewHolder: ");
        holder.confirmed.setText(model.getConfirmed());
        if(model.getConfirmed().equals("Pending")){
            holder.imageView.setImageResource(R.drawable.ic_history_black_24dp);
        }
        if (model.getConfirmed().equals("Rejected") || model.getConfirmed().equals("Cancelled")){
            holder.imageView.setImageResource(R.drawable.ic_delete_black_24dp);
        }
        holder.doctor_name.setText(model.getDoctor_name());
        holder.timing.setText(model.getTiming());
        holder.hospital_name.setText(model.getHospital_name());
        holder.date.setText(model.getDate());
        holder.token.setText("Token : " + model.getToken());
        if(model.getConfirmed().equals("Rejected") || model.getConfirmed().equals("Cancelled")){
            holder.cancel.setText("");
        }
        else {
            holder.cancel.setText("Cancel");
        }

    }

public interface intee{
        void suff(Appointmentlist apo);
}


    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView confirmed;
        TextView doctor_name;
        TextView hospital_name;
        TextView timing;
        TextView date;
        TextView token;
        TextView cancel;
ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            confirmed =itemView.findViewById(R.id.confirmed);
            doctor_name = itemView.findViewById(R.id.doctor_name);
            hospital_name = itemView.findViewById(R.id.hospital_name);
            timing = itemView.findViewById(R.id.timing);
            imageView = itemView.findViewById(R.id.checke);
            date    = itemView.findViewById(R.id.date);
            cancel = itemView.findViewById(R.id.cancel);
            token    = itemView.findViewById(R.id.tokenn);
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position!= RecyclerView.NO_POSITION && ee!=null){
                       apo = getItem(position);
                        ee.suff(apo);
                    }

                }
            });
        }
    }
}
