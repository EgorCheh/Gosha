package com.example.gosha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class JobDetail extends AppCompatActivity {

    private FirebaseFirestore db;
    private Bundle arguments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        db=FirebaseFirestore.getInstance();
         arguments = getIntent().getExtras();

        findViewById(R.id.btn_delete).setVisibility(View.INVISIBLE);
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Jobs").document(arguments.getString("id"))
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"DocumentSnapshot successfully deleted!",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),MyJobs.class));
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });

            }
        });
        TextView tvContacts,tvTitle,tvDescription,tvPrice;
        tvContacts=findViewById(R.id.tv_contact);
        tvTitle=findViewById(R.id.tv_title);
        tvDescription=findViewById(R.id.tv_description);
        tvPrice=findViewById(R.id.tv_price);

        assert arguments != null;
        tvTitle.setText(arguments.getString("title"));
        tvPrice.setText(arguments.getString("price"));
        tvDescription.setText(arguments.getString("Description"));
        String contact=arguments.getString("Name")+"\n"+arguments.getString("Contacts")+"\n"+arguments.getString("Address");
        tvContacts.setText(contact);
        try {
           if(!arguments.getString("activity").isEmpty()){
               findViewById(R.id.btn_delete).setVisibility(View.VISIBLE);
           }
        }catch (Exception ignored){}


    }
}
