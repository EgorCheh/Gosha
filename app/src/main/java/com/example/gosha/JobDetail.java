package com.example.gosha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JobDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        Bundle arguments = getIntent().getExtras();

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
    }
}
