package com.example.gosha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_menu);
        Button btnProfile,btnAll,btnMy,btnCreate,btnInfo;
        btnProfile = findViewById(R.id.btn_profile_profmenu);
        btnAll = findViewById(R.id.btn_all_jobs_profmenu);
        btnMy = findViewById(R.id.btn_my_jobs_profmenu);
        btnCreate = findViewById(R.id.btn_create_profmenu);
        btnInfo = findViewById(R.id.btn_info_profmenu);
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