package com.rku.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editUsername;
    EditText editPassword;
    Button btnLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUsername=findViewById(R.id.editUsername);
        editPassword=findViewById(R.id.editPassword);
        btnLogin=findViewById(R.id.btnLogin);
        sharedPreferences=getSharedPreferences("student",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        String username=sharedPreferences.getString("username","");
        if(!username.equals(""))
        {
            Intent intent=new Intent(MainActivity.this,Welcome.class);
            intent.putExtra("userdata",username);
            startActivity(intent);
            finish();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valUsername=editUsername.getText().toString();
                String valPassword=editPassword.getText().toString();
                if(validateEmail(valUsername))
                {
                    if(valUsername.equals("admin@gmail.com") && valPassword.equals("12345"))
                    {
                        editor.putString("username",valUsername);
                        editor.commit();
                        Intent intent=new Intent(MainActivity.this,Welcome.class);
                        intent.putExtra("userdata",valUsername);
                        startActivity(intent);
                        finish();
                        Toast.makeText(MainActivity.this, "Login successfully",Toast.LENGTH_LONG).show();

                    }

                }
                else
                {
                    Toast.makeText(MainActivity.this, "Username or password is incorrect",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    public boolean validateEmail(String email)
    {
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    }
