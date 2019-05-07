package com.example.gosha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {
    private String TAG="menuDeb";
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth =FirebaseAuth.getInstance();

        Log.d(TAG,mAuth.getCurrentUser().getEmail());
    }
}
