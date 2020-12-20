package com.example.myapplication.util.fragments.Bottom_navigation_fragments.Search;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Main8Activity;
import com.example.myapplication.R;
import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.model.Lists;
import com.example.myapplication.util.RecyclerviewAdapter.Re;
import com.example.myapplication.util.T;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class pp1 extends Fragment {
    FirebaseFirestore c = FirebaseFirestore.getInstance();
    RecyclerView recyclerView ;
    Re re;
    Lists lists = Lists.getInstance();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.previous,container,false);
        Query query = c.collection(lists.getCAPITALS()).document(lists.getName()).collection("Appointmnet").document("bookings").collection("previous").orderBy("date"  , Query.Direction.ASCENDING) ;
        FirestoreRecyclerOptions<Appointmentlist> options =new FirestoreRecyclerOptions.Builder<Appointmentlist>().setQuery(query,Appointmentlist.class).build();
        re =  new Re(options, new Re.intee() {
            @Override
            public void suff(Appointmentlist apo) {
//                startActivity(new Intent(getActivity(), Main8Activity.class));
//                new AlertDialog.Builder(getContext())
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setTitle("Cancel Appointment")
//                        .setMessage("Are you sure you want to cancel the appointment?")
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
//                        {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(getContext(),"Appointment Canceled", Toast.LENGTH_SHORT).show();
//                            }
//
//                        })
//                        .setNegativeButton("No", null)
//                        .show();
            }
        });
        recyclerView = view.findViewById(R.id.recyce);
        Log.d("start_Listening", "onCreateView: ");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(re);
        re.startListening();
        return view;
    }
    @Override
    public void onStop() {
        super.onStop();
        re.startListening();
    }
    @Override
    public void onStart() {
        super.onStart();
        re.startListening();
    }
}
