package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.model.Appointmentlist;
import com.example.myapplication.util.RecyclerviewAdapter.RecyclerViewAdapter;
import com.example.myapplication.util.fragments.Book;
import com.example.myapplication.util.fragments.Change;
import com.example.myapplication.util.fragments.History;
import com.example.myapplication.util.fragments.Home_fragment;
import com.example.myapplication.util.fragments.Share;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;


public class Main4Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , Home_fragment.HomeButtonselection {
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    TextView tt;
    Toolbar tool;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Home_fragment home_fragment;
    public RecyclerView recyclerView;
    public RecyclerViewAdapter recyclerViewAdapter;
    int a =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
         tool = findViewById(R.id.too);
        setSupportActionBar(tool);
        tt = findViewById(R.id.hospitalname);
home_fragment = new Home_fragment();
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout ,tool,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        fragmentManager = getSupportFragmentManager();
         fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,home_fragment);
        fragmentTransaction.commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.side_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                Log.d("add", "onOptionsItemSelected: ");
                break;
            case  R.id.settings:
                Log.d("settings", "onOptionsItemSelected: ");

                break;
            case R.id.logout:
                Log.d("logout", "onOptionsItemSelected: ");

                break;
             default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()) {

            case R.id.home:
                 fragmentManager = getSupportFragmentManager();
                 fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, home_fragment);
                fragmentTransaction.commit();
                break;
            case R.id.book:
                 fragmentManager = getSupportFragmentManager();
                 fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,new Book());
                fragmentTransaction.commit();
                break;

            case R.id.change:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,new Change());
                fragmentTransaction.commit();
                break;

            case R.id.History:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,new History());
                fragmentTransaction.commit();
                break;
            case R.id.share:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,new Share());
                fragmentTransaction.commit();
                break;
            default:
                break;

        }
        return false;
    }

    @Override
    public void btnselected() {




    }

    }



