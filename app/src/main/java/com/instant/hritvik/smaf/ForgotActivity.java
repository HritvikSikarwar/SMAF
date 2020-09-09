package com.instant.hritvik.smaf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotActivity extends AppCompatActivity {

    ImageView logo;
    TextView reset_heading, user_text, password_text;
    EditText user_edittext, newpassword_edittext, conferm_newpassword_edittext;
    Button resetpassword_btn, cancle_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        resetpassword_btn = findViewById(R.id.resetpassword_btn);
        cancle_btn = findViewById(R.id.cancle_btn);


        resetpassword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotActivity.this, DashboardActivity.class));
            }
        });
        cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ForgotActivity.this, ForgotActivity.class));
            }
        });

    }

    public void openfinduserActivity() {
        Intent intent = new Intent(ForgotActivity.this, ForgotActivity.class);
        startActivity(intent);
    }
}