package com.example.myapplication;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.model.Hospital;
import com.example.myapplication.model.Lists;
import com.example.myapplication.model.Patient;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Article_fragment;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.History;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Home_fragment;
import com.example.myapplication.util.fragments.Bottom_navigation_fragments.Profile_fragment;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class Main4Activity extends AppCompatActivity  implements  Home_fragment.onbuttonclk{
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    TextView tt;
public static Main4Activity fa;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    RecyclerView re;
//    RecyclerViewAdapter adapter ;
    FragmentTransaction fragmentTransaction;
    Home_fragment home_fragment;
FirebaseFirestore fb = FirebaseFirestore.getInstance();
    ArrayList<Hospital> hospitalLists ;
History history;
Profile_fragment profile_fragment;
Article_fragment article_fragment;
    public RecyclerView recyclerView;
//    public RecyclerViewAdapter recyclerViewAdapter;
    BottomNavigationView bottomNavigationView;
//    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener;
    int a = 0;
    Lists lists = Lists.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main5);
        fa = this;
        Log.d("03030303", "onCreate: ");
//        Lists lists =   new Lists();
//       hospitalLists =   lists.getting_lists(new Callback() {
//            @Override
//            public void calling(ArrayList<Hospital> hospital) {
//
//            }
//        });
//        Log.d("qwertyuioplkj", "onCreate: "+ hospitalLists.size());
//        Log.d(TAG, "onCreate: "lists.hospitals_lists.get(0);
        home_fragment = new Home_fragment(new Home_fragment.onclickkaro() {
            @Override
            public void karo() {
                new CountDownTimer(500,500){

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        bottomNavigationView.setSelectedItemId(R.id.History);
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new History()).commit();
                    }
                }.start();

            }
        });
        history = new History();
        profile_fragment = new Profile_fragment(new Profile_fragment.utii() {
            @Override
            public void frg(Patient pp, final View v) {
fb.collection(lists.getCAPITALS()).document(lists.getName()).collection("profile").document("profile").set(pp).addOnSuccessListener(new OnSuccessListener<Void>() {
    @Override
    public void onSuccess(Void aVoid) {

        Snackbar.make(v, "Successfully changed", Snackbar.LENGTH_LONG).show();
    }
});
            }
        });
        article_fragment = new Article_fragment();

        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);


//        navigationView = findViewById(R.id.navigation_view)
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout ,tool,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
//        actionBarDrawerToggle.syncState();
        fragmentManager = getSupportFragmentManager();
         fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,home_fragment);
        fragmentTransaction.commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()){
                case R.id.home:
                    new CountDownTimer(500,500){

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            fragmentManager =getSupportFragmentManager();
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frameLayout,home_fragment).commit();
                        }
                    }.start();
                 ;
                    break;
                case R.id.History:
                    new CountDownTimer(500,500){

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new History()).commit();
                        }
                    }.start();
                    Log.d("020202020201", "onNavigationItemSelected: ");


                    break;
//                case R.id.article:
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,article_fragment).commit();
//                    break;
                case R.id.Profile:
                    new CountDownTimer(500,500){

                        @Override
                        public void onTick(long millisUntilFinished) {

                        }

                        @Override
                        public void onFinish() {
                            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,profile_fragment).commit();
                        }
                    }.start();

                    break;
            }
            return true;
        }
    };

//    }
//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
    int i;
   public void calling(Hospital hospital){
        hospitalLists.add(hospital);

    }

    @Override
    public void onBackPressed() {
         i=0;
        if(bottomNavigationView.getSelectedItemId() == R.id.History || bottomNavigationView.getSelectedItemId()  == R.id.Profile){
            bottomNavigationView.setSelectedItemId(R.id.home);

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,home_fragment).commit();
        }
        else{
            delaying();
            new CountDownTimer(500,500){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Main4Activity.super.onBackPressed();
            }
        }.start();
            Log.d("inging", "onBackPressed: " + i);
        if(i==1){

        }}
    }

    private void delaying() {
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            case R.id.share:

//
//                break;
//            case  R.id.settings:
//
//
//                break;
            case R.id.logout:

lists.getFirebaseAuth().signOut();
startActivity(new Intent(Main4Activity.this,Main2Activity.class));
finish();
                break;
             default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void click(int id) {
        switch (id){
            case R.id.book_appointment:
                startActivity(new Intent(Main4Activity.this,Book_appointment.class));

        break;
    }}

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("04040404", "onStart: ");
    }
}



