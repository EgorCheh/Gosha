package com.example.gosha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_menu);

        Button btnProfile,btnAll,btnMy,btnCreate,btnInfo,btnLogOut;
        final FirebaseAuth mAuth=FirebaseAuth.getInstance();


        btnLogOut=findViewById(R.id.log_out);
        btnProfile = findViewById(R.id.btn_profile_profmenu);
        btnAll = findViewById(R.id.btn_all_jobs_profmenu);
        btnMy = findViewById(R.id.btn_my_jobs_profmenu);
        btnCreate = findViewById(R.id.btn_create_profmenu);


        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
                finish();


            }
        });

        btnAll.setOnClickListener(this);
        btnCreate.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnMy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_all_jobs_profmenu :
            {
                finish();
                break;
            }
            case R.id.btn_profile_profmenu:
            {
                startActivity(new Intent(getApplicationContext(),ProfileDetailActivity.class));

                break;
            }
            case R.id.btn_my_jobs_profmenu :
            {

                break;
            }

            case R.id.btn_create_profmenu :
            {
                startActivity(new Intent(getApplicationContext(),SelectCategory.class));
                break;
            }
            default:break;


        }
    }
}
