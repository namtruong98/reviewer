package com.example.truong.project;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Activity_signup extends AppCompatActivity {
    private EditText edt_mail,edt_password;
    private Button btnLogin,btn_fb,btn_gmail;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getSupportActionBar().hide();
            setContentView(R.layout.activity_signup);
            LoginFr();

    }
    private void LoginFr(){
        edt_mail = (EditText)findViewById(R.id.edt_mail);
        edt_password = (EditText)findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = edt_mail.getText().toString().trim();
                String password = edt_password.getText().toString().trim();
                if (TextUtils.isEmpty(mail)){
                    Toast.makeText(Activity_signup.this, "Plase enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Activity_signup.this, "Plase enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth = firebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(mail,password)
                        .addOnCompleteListener(Activity_signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(Activity_signup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent i2 = new Intent(Activity_signup.this, MainActivity.class);
                                    startActivity(i2);
                                }
                                else {
                                    Toast.makeText(Activity_signup.this, "Could not register... Please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });
    }
    private void LoginFacebook(){

    }
}