package com.example.gosha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddJob extends AppCompatActivity {
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();

        Job job = new Job("Title",45,"descript","addres","4568464",mAuth.getCurrentUser().getEmail());


        db.collection("Jobs").document(job.getId().toString()).set(job);


        }

    }

