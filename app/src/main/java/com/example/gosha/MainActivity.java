package com.example.gosha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth;
    private String TAG="maindeb";
    private EditText etEmail,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSignIn = findViewById(R.id.btn_sign_in);
        Button btnSignUp = findViewById(R.id.btn_sign_up);
         etEmail = findViewById(R.id.et_email);
         etPassword = findViewById(R.id.et_password);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();



        Log.d(TAG," create  "+mAuth.getCurrentUser());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_sign_in:{

                singIn(etEmail.getText().toString(),etPassword.getText().toString());

                break;
            }
            case R.id.btn_sign_up:{

                Intent intent = new Intent(this, Registration.class);
                startActivity(intent);
                break;
            }
            default:break;
        }
    }


    public void singIn(String email,String password){

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void userIdentified(){
        if(mAuth.getCurrentUser()!=null)
        {
            Intent intent = new Intent(getApplicationContext(), Menu.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        userIdentified();

    }
}
