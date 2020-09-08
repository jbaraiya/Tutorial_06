package com.rku.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        txtWelcome=findViewById(R.id.txtWelcome);
        txtWelcome.setText("Welcome: "+getIntent().getStringExtra("userdata"));

    }
}
