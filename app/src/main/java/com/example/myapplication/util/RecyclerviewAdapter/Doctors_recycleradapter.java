package com.example.myapplication.util.RecyclerviewAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Doctors;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Doctors_recycleradapter extends FirestoreRecyclerAdapter<Doctors,Doctors_recycleradapter.ViewHolder> {

OnitemListener onitemListener;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Doctors_recycleradapter(@NonNull FirestoreRecyclerOptions<Doctors> options) {
        super(options);
    }
    public interface OnitemListener{
            public void onItemClick(int position);
}
public void setOnitemListener(OnitemListener onitemListener){
       this.onitemListener =    onitemListener;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_card_view,parent,false);
        Log.d("binderee", "onBindViewHolder: "  );
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Doctors model) {
   holder.doctor_name.setText(model.getName());
        Log.d("binder", "onBindViewHolder: " + model.getDoctors_Department());
        holder.Depart_name.setText(model.getDoctors_Department());
        holder.ratingbar.setText(model.getStars());
        holder.rating.setRating(Float.parseFloat(model.getStars()));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
TextView doctor_name;
TextView Depart_name;
TextView ratingbar;
RatingBar rating;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            doctor_name = itemView.findViewById(R.id.doctors_name);
            Depart_name = itemView.findViewById(R.id.department_namee);
            ratingbar = itemView.findViewById(R.id.rating);
            rating = itemView.findViewById(R.id.doctors_stars);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onitemListener!= null){
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION){
                            onitemListener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }
}
