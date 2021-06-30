package com.example.amstuckshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class homePage extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button bSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.school_email);
        etPassword = (EditText) findViewById(R.id.password);
        bSignIn = (Button) findViewById(R.id.sign_in_btn);
    }
}