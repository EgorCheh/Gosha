package com.example.gosha;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registration extends AppCompatActivity {
    private EditText etFname,etLname,etEmail,etPassword;
    private Button btnSubmit;
    private FirebaseAuth mAuth;
    private User currentUser;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        etFname=findViewById(R.id.et_descr);
        etLname=findViewById(R.id.et_l_name_reg);
        etEmail=findViewById(R.id.et_email_reg);
        etPassword=findViewById(R.id.et_password_reg);
        btnSubmit=findViewById(R.id.btn_to_regist);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signUp(etEmail.getText().toString(),etPassword.getText().toString());
            }

        });

        }

    public void signUp (String email , String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
                    currentUser = new User(mAuth.getUid(),etFname.getText().toString(), etLname.getText().toString(), " ", " ", null, null, etEmail.getText().toString(), etPassword.getText().toString());
                    db.collection("Users").document(currentUser.getId().toString()).set(currentUser);
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
