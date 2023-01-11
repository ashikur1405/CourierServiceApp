package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Coverage extends AppCompatActivity {
    BottomNavigationView bot_nav;

    TextView dhaka;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coverage);

        bot_nav=findViewById(R.id.nav);
        bot_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home:
                        Intent intent=new Intent(Coverage.this,Home.class);
                        startActivity(intent);
                        break;
                    case R.id.profile:
                        Toast.makeText(Coverage.this,"User profile",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.chat:
                        Toast.makeText(Coverage.this,"Live chat room",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        dhaka=findViewById(R.id.dhaka);
        dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Coverage.this,Subarea.class);
                startActivity(intent);
                finish();
            }
        });
    }
}