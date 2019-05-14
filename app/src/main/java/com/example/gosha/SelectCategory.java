package com.example.gosha;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectCategory extends AppCompatActivity {
    private HashMap<String, Object> category;
    private ArrayList<HashMap<String, Object>> listCategory = new ArrayList<>();
    private SimpleAdapter adapter;
    private String TAG="SelectCategory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                category = new HashMap<>();
                                category.put("category",document.getId());
                                listCategory.add(category);



                            }setAdapter();
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });




    }

    private void setAdapter() {
        String[] from = { "category" };
        int[] to = { R.id.tv_category};

        adapter = new SimpleAdapter(this, listCategory, R.layout.lv_item_categoty, from, to);
        ListView listView = findViewById(R.id.lv_category);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),AddJob.class));
            }
        });
        listView.setAdapter(adapter);
    }
}
