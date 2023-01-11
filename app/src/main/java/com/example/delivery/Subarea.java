package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Subarea extends AppCompatActivity {
    BottomNavigationView bot_nav;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subarea);

        bot_nav=findViewById(R.id.nav);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        Intent intent=new Intent(Subarea.this,Home.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        Toast.makeText(Subarea.this,"User profile",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(Subarea.this,"Live chat room",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}