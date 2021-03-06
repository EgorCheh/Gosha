package com.example.gosha;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;

public class MyJobs extends AppCompatActivity {
    private String TAG="menuDeb";
    private FirebaseAuth mAuth;
    private SimpleAdapter adapter;
    private HashMap<String, Object> job;
    private ArrayList<HashMap<String, Object>> jobs = new ArrayList<>();
    private ProgressBar progressBar ;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        progressBar = findViewById(R.id.progressBar2);
        mAuth =FirebaseAuth.getInstance();

        imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProfileMenu.class);
                startActivity(intent);

            }
        });
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Jobs")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());



                                if(document.getData().get("mail").equals(mAuth.getCurrentUser().getEmail())) {
                                    job = new HashMap<>();
                                    job.put("title", document.getData().get("title"));
                                    job.put("price", document.getData().get("price"));
                                    job.put("contact", document.getData().get("contact"));
                                    job.put("description", document.getData().get("description"));
                                    job.put("address", document.getData().get("address"));
                                    job.put("mail", document.getData().get("mail"));
                                    job.put("id", document.getId());
                                    jobs.add(job);
                                }



                            }setAdapter();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }

    private void setAdapter(){

        progressBar.setVisibility(ProgressBar.INVISIBLE);
        String[] from = { "title",  "price"};
        int[] to = { R.id.itemTvTitle, R.id.itemTvPrice,};

        adapter = new SimpleAdapter(this, jobs, R.layout.item_lv_menu, from, to);
        ListView listView = findViewById(R.id.lv_menu);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),JobDetail.class);

                //intent.putExtra("id",jobs.get(position).get("id").toString());
                intent.putExtra("title",jobs.get(position).get("title").toString());
                intent.putExtra("price",jobs.get(position).get("price").toString());
                intent.putExtra("Description",jobs.get(position).get("description").toString());
                intent.putExtra("Contacts",jobs.get(position).get("contact").toString());
                intent.putExtra("Address",jobs.get(position).get("address").toString());
                intent.putExtra("Name",jobs.get(position).get("mail").toString());
                intent.putExtra("activity","activity");
                intent.putExtra("id",jobs.get(position).get("id").toString());
                startActivity(intent);
                finish();

            }
        });

        listView.setAdapter(adapter);
    }
}