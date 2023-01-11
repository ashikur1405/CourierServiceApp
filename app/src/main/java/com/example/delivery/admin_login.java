package com.example.delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class admin_login extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        e1=findViewById(R.id.mail1);
        e2=findViewById(R.id.pass1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        b1.setOnClickListener(view -> {
            String textN=e1.getText().toString();
            String textP=e2.getText().toString();
            if((textN.equals("admin")) && (textP.equals("admin"))) {
                Intent intent = new Intent(getApplicationContext(),Admin_Panel.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(admin_login.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}