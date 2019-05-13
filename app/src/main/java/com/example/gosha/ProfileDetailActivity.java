package com.example.gosha;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Objects;

public class ProfileDetailActivity extends AppCompatActivity {
    private Button btnEdit;
    private EditText etName,etLName,etInfo,etAddress,etContact,etAge;
    private User currentUser=new User();
    private Boolean save =false;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private  HashMap<String, Object> userData = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        mAuth=FirebaseAuth.getInstance();


         btnEdit=findViewById(R.id.btn_edit_profile);

        etName=findViewById(R.id.et_name_edit_profile);
        etLName=findViewById(R.id.et_l_name_edit_profile);
        etInfo=findViewById(R.id.et_info_edit_profile);
        etAddress=findViewById(R.id.et_address_edit_profile);
        etContact=findViewById(R.id.et_contact_edit_profile);
        etAge=findViewById(R.id.et_age_edit_profile);



        etName.setEnabled(false);
        etLName.setEnabled(false);
        etInfo.setEnabled(false);
        etAddress.setEnabled(false);
        etContact.setEnabled(false);
        etAge.setEnabled(false);


        db = FirebaseFirestore.getInstance();

        btnEdit.setOnClickListener(new View.OnClickListener() {
             @RequiresApi(api = Build.VERSION_CODES.M)
             @SuppressLint("ResourceAsColor")
             @Override
             public void onClick(View v) {

                 if(save){

                     btnEdit.setText("Edit Profile");

                    btnEdit.setEnabled(false);

                     etName.setEnabled(false);
                     etName.setTextColor(Color.BLACK);
                     userData.put("fname",etName.getText().toString());

                     etLName.setEnabled(false);
                     etLName.setTextColor(Color.BLACK);
                     userData.put("sname",etLName.getText().toString());

                     etInfo.setEnabled(false);
                     etInfo.setTextColor(Color.BLACK);
                     userData.put("userInfo",etInfo.getText().toString());

                     etAddress.setEnabled(false);
                     etAddress.setTextColor(Color.BLACK);
                     userData.put("address",etAddress.getText().toString());

                     etContact.setEnabled(false);
                     etContact.setTextColor(Color.BLACK);
                     userData.put("contact",etContact.getText().toString());

                     etAge.setEnabled(false);
                     etAge.setTextColor(Color.BLACK);
                     userData.put("age",etAge.getText().toString());



                     DocumentReference docRef = db.collection("Users").document(Objects.requireNonNull(mAuth.getUid()));


                     docRef.update(userData).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                      @Override
                                                                      public void onComplete(@NonNull Task<Void> task) {
                                                                          btnEdit.setEnabled(true);
                                                                      }
                                                                  });

                     save=false;
                 }else {

                     btnEdit.setText("Save");

                     etName.setEnabled(true);
                     etName.setTextColor(Color.GRAY);

                     etLName.setEnabled(true);
                     etLName.setTextColor(Color.GRAY);

                     etInfo.setEnabled(true);
                     etInfo.setTextColor(Color.GRAY);

                     etAddress.setEnabled(true);
                     etAddress.setTextColor(Color.GRAY);

                     etContact.setEnabled(true);
                     etContact.setTextColor(Color.GRAY);

                     etAge.setEnabled(true);
                     etAge.setTextColor(Color.GRAY);

                     save=true;
                 }




             }
         });

        readUserData();

    }

    private void readUserData() {


        DocumentReference docRef = db.collection("Users").document(mAuth.getUid());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                currentUser = documentSnapshot.toObject(User.class);

                etName.setText(currentUser.getFname());
                etLName.setText(currentUser.getSname());
                etInfo.setText(currentUser.getUserInfo());
                etAddress.setText(currentUser.getAddress());
                etContact.setText(currentUser.getContact());
                etAge.setText(currentUser.getAge());
            }
        });

    }
}
