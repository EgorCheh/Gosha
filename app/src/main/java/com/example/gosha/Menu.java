package com.example.gosha;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class Menu extends AppCompatActivity {
    private String TAG="menuDeb";
    private FirebaseAuth mAuth;
    private SimpleAdapter adapter;
    private HashMap<String, Object> job;
    private ArrayList<HashMap<String, Object>> jobs = new ArrayList<>();
    private ProgressBar progressBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        progressBar = findViewById(R.id.progressBar2);
        mAuth =FirebaseAuth.getInstance();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Jobs")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());


                                job = new HashMap<>();
                                job.put("title",  document.getData().get("Title"));
                                job.put("price",  document.getData().get("Price"));
                                jobs.add(job);


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
        listView.setAdapter(adapter);
    }
}
