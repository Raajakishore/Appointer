package com.example.myapplication;

import android.graphics.PointF;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView tt1;
   LineView lv1;
  LineView lv2;
        lv1 = findViewById(R.id.lv1);
        lv2 = findViewById(R.id.lv2);
        PointF pointA = new PointF(15,500);
        PointF pointB = new PointF(180,500);
        PointF pointC = new PointF(230,500);
        PointF pointD = new PointF(400,500);

        lv1.setpointA(pointA);
        lv1.setpointB(pointB);
        lv2.setpointA(pointC);
        lv2.setpointB(pointD);
        lv1.draw();
        lv2.draw();
    }

}