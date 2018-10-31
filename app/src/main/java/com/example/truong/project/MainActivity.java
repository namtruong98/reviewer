package com.example.truong.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity {
    private EditText edt_login_mail,edt_login_password;
    private Button btnLogin,btn_fb,btn_gmail;
    private FirebaseAuth firebaseAuth;
    private TextView tv_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getSupportActionBar().hide();
            setContentView(R.layout.activity_main);
            LoginFr();
            tv_signup = (TextView)findViewById(R.id.tv_signup);
            tv_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i1 = new Intent(MainActivity.this,Activity_signup.class);
                    startActivity(i1);
                }
            });

    }
    private void LoginFr(){
        edt_login_mail = (EditText)findViewById(R.id.edt_login_mail);
        edt_login_password = (EditText)findViewById(R.id.edt_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = edt_login_mail.getText().toString().trim();
                String password = edt_login_password.getText().toString().trim();
                if (TextUtils.isEmpty(mail)){
                    Toast.makeText(MainActivity.this, "Plase enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity.this, "Plase enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth = firebaseAuth.getInstance();
                if (firebaseAuth.getCurrentUser()!= null){

                }
                firebaseAuth.signInWithEmailAndPassword(mail,password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(MainActivity.this, "Login unsuccessful\n... Please try again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });
    }
    private void LoginFacebook(){

    }
}
