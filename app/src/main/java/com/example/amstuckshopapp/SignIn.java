package com.example.amstuckshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private TextView Logo;
    private TextView AMSHeading;
    private TextView SignInText;
    private EditText Email;
    private EditText Password;
    private Button SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Logo = (TextView) findViewById(R.id.logo);
        AMSHeading = (TextView) findViewById(R.id.heading);
        SignInText = (TextView) findViewById(R.id.sign_in_heading);
        Email = (EditText) findViewById(R.id.school_email);
        Password = (EditText) findViewById(R.id.password);
        SignIn = (Button) findViewById(R.id.sign_in_btn);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    }

    //Move to Homepage.
    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(SignIn.this, homePage.class);
            startActivity(intent);
        }
    }
}