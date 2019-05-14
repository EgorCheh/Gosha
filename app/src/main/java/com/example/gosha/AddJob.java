package com.example.gosha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddJob extends AppCompatActivity {
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private EditText etTitle,etContact,etDescr,etPrice,etAddrest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_job);
        db = FirebaseFirestore.getInstance();
        mAuth=FirebaseAuth.getInstance();
        etAddrest=findViewById(R.id.et_addr);
        etContact=findViewById(R.id.et_contact);
        etDescr=findViewById(R.id.et_descr);
        etPrice=findViewById(R.id.et_price);
        etTitle=findViewById(R.id.et_title);




        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Job job = new Job(etTitle.getText().toString(), Double.parseDouble( etPrice.getText().toString()),etDescr.getText().toString(),etAddrest.getText().toString(),etContact.getText().toString(),mAuth.getCurrentUser().getEmail());
                db.collection("Jobs").document(job.getId().toString()).set(job);
                Toast.makeText(getApplicationContext(),"Succses",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        }

    }

