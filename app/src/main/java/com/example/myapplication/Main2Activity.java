package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.data.Databasehandler;
import com.example.myapplication.model.Patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private Databasehandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
        db=new Databasehandler(this);

        username=findViewById(R.id.ed1);
        password=findViewById(R.id.ed2);
        login=findViewById(R.id.tt2);
        register=findViewById(R.id.tt3);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        TextView tt1;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Patient patient= db.login(username.getText().toString(),password.getText().toString());
              if(patient!=null){
                 startActivity(new Intent(Main2Activity.this, Main4Activity.class));
              }
              else{


              }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this,Main3Activity.class));

            }
        });
    }

}

//   LineView lv1;
//  LineView lv2;
//        lv1 = findViewById(R.id.lv1);
//        lv2 = findViewById(R.id.lv2);
//        PointF pointA = new PointF(15,500);
//        PointF pointB = new PointF(180,500);
//        PointF pointC = new PointF(230,500);
//        PointF pointD = new PointF(400,500);

//        lv1.setpointA(pointA);
//        lv1.setpointB(pointB);
//        lv2.setpointA(pointC);
//        lv2.setpointB(pointD);
//        lv1.draw();
//        lv2.draw();