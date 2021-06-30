package com.example.amstuckshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity{

    TextView tvLogo;
    TextView tvAMSHeading;
    TextView tvSignInText;
    EditText etEmail;
    EditText etPassword;
    Button bSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        tvLogo = (TextView) findViewById(R.id.logo);
        tvAMSHeading = (TextView) findViewById(R.id.heading);
        tvSignInText = (TextView) findViewById(R.id.sign_in_heading);
        etEmail = (EditText) findViewById(R.id.school_email);
        etPassword = (EditText) findViewById(R.id.password);
        bSignIn = (Button) findViewById(R.id.sign_in_btn);


    }
}