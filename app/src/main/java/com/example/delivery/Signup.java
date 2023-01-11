package com.example.delivery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class Signup extends AppCompatActivity {
    Button signup;
    EditText name,email,phone,password,cpass;
    TextView login;
    FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth=FirebaseAuth.getInstance();

        name=findViewById(R.id.username);
        email=findViewById(R.id.usermail);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.pass);
        cpass=findViewById(R.id.cpass);

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Signup.this,MainActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String nem=name.getText().toString();
                String mail=email.getText().toString();
                String phn =phone.getText().toString();
                String pass=password.getText().toString();
                String conpass=cpass.getText().toString();

                if (nem.isEmpty()){
                    name.setError("need");
                    return;
                }if (mail.isEmpty()){
                    email.setError("need");
                    return;
                }if (phn.isEmpty()){
                    phone.setError("need");
                    return;
                }if (pass.isEmpty()){
                    password.setError("need");
                    return;
                }if (conpass.isEmpty() || !pass.equals(conpass)){
                    cpass.setError("need");
                    return;
                }
                createAccount(mail,pass);
            }
        });
    }
    private void createAccount(String email,String password)
    {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    FirebaseUser user=auth.getCurrentUser();
                    updateUI(user,email);
                    Toast.makeText(Signup.this,"Account Created Successfully",Toast.LENGTH_SHORT).show();
                }else
                {
                    Toast.makeText(Signup.this,"Sign-up failed"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void updateUI(FirebaseUser user,String email)
    {
        HashMap<String,Object> map=new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("email",email);
        map.put("phone",phone.getText().toString());

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("user");
        reference.child(user.getUid())
                .setValue(map)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(Signup.this,MainActivity.class));
                            finish();
                            Toast.makeText(Signup.this,"Account Created Successfully",Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(Signup.this,"Sign-up failed"+ Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}