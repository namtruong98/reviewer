package com.example.truong.project;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    public static EditText edt_search;
    private TextView qrcodobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getSupportActionBar().hide();
          setContentView(R.layout.activity_home);
            edt_search = (EditText)findViewById(R.id.edt_search);
            qrcodobar = (TextView)findViewById(R.id.qrcodobar);

             qrcodobar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),ScanCodeActivity.class));
                }
            });
    }

}