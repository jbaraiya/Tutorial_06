package com.rku.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.rku.tutorial06.MainActivity;
import com.rku.tutorial06.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splesh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(Splesh.this, MainActivity.class);

                startActivity(intent);
                finish();
            }
        },2000);
    }
}
