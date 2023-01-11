package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Admin_Panel extends AppCompatActivity {
    BottomNavigationView bot_nav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        bot_nav=findViewById(R.id.nav);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        Intent intent=new Intent(Admin_Panel.this,Home.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        Toast.makeText(Admin_Panel.this,"User profile",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(Admin_Panel.this,"Live chat room",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}