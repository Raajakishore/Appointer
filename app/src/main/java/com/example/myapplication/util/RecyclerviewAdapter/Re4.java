
package com.example.myapplication.util.RecyclerviewAdapter;

        import android.content.Context;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.RatingBar;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.myapplication.R;
        import com.example.myapplication.model.Doctors;
        import com.example.myapplication.model.Hospital;
        import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
        import com.firebase.ui.firestore.FirestoreRecyclerOptions;

        import java.util.ArrayList;

public class Re4 extends FirestoreRecyclerAdapter<Doctors,Re4.ViewHolder> {
    inteee ee;

    Doctors apo ;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */

    public Re4(@NonNull FirestoreRecyclerOptions<Doctors> options, inteee i) {
        super(options);
        ee = i;
    }

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Re4(@NonNull FirestoreRecyclerOptions<Doctors> options) {
        super(options);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout_view,parent,false);
        Log.d("create_is_working", "onBindViewHolder: ");
        return new ViewHolder(view);
    }
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Doctors model) {

        holder.name.setText(model.getName());
        holder.stars_rating.setRating(Float.parseFloat(model.getStars()));
        holder.star.setText(model.getStars().toString());
holder.Department.setText(model.getDepartment());
holder.hospiatl_name.setText(model.getHospital_name());
    }

    public interface inteee{
        void suffe(Doctors apo);
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{
           public TextView name;
        public RatingBar stars_rating;
public TextView star;
public  TextView Department;
public  TextView hospiatl_name;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
          super(itemView);
            name = itemView.findViewById(R.id.namee);
            stars_rating = itemView.findViewById(R.id.ratingBar2);
            star = itemView.findViewById(R.id.star);
            hospiatl_name= itemView.findViewById(R.id.hospital_name);

            Department = itemView.findViewById(R.id.Department);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos !=RecyclerView.NO_POSITION && ee!=null){
                       Doctors doc =  getItem(pos);
                    ee.suffe(doc);
                    }
                }
            });
    }
}}
///Filter filter = new Filter() {
//    @Override
//    protected FilterResults performFiltering(CharSequence constraint) {
//        List<Doctors> filters = new ArrayList<>();
//        String search_query = constraint.toString().toUpperCase().trim();
//        if(search_query == null || search_query == ""){
//filters.addAll(doc);
//        }
//        else{
//for(Doctors d : doc){
//    if(d.getName().toUpperCase().contains(search_query)){
//        filters.add(d);
//    }
//}
//        }
//
//        FilterResults filterResults = new FilterResults();
//        filterResults.values = filters;
//        return filterResults;
//    }
//
//    @Override
//    protected void publishResults(CharSequence constraint, FilterResults results) {
//doctors.clear();
//doctors.addAll((List) results.values);
//notifyDataSetChanged();
//    }
//};

//    @Override
//    public Filter getFilter() {
//        return filter;
//    }