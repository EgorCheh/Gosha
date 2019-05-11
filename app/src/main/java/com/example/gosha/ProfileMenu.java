package com.example.gosha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

       Log.d("asadasdada","Profile  "+mAuth.getCurrentUser().getEmail());


        btnLogOut=findViewById(R.id.log_out);
        btnProfile = findViewById(R.id.btn_profile_profmenu);
        btnAll = findViewById(R.id.btn_all_jobs_profmenu);
        btnMy = findViewById(R.id.btn_my_jobs_profmenu);
        btnCreate = findViewById(R.id.btn_create_profmenu);
        btnInfo = findViewById(R.id.btn_info_profmenu);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


            }
        });

        btnAll.setOnClickListener(this);
        btnCreate.setOnClickListener(this);
        btnProfile.setOnClickListener(this);
        btnMy.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
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

                break;
            }
            case R.id.btn_my_jobs_profmenu :
            {

                break;
            }
            case R.id.btn_info_profmenu :
            {

                break;
            }
            case R.id.btn_create_profmenu :
            {

                break;
            }
            default:break;


        }
    }
}
