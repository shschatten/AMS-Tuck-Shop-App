package com.example.amstuckshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    TextView appname;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        appname = findViewById(R.id.amstuckshop);
        lottie = findViewById(R.id.lottie);

        lottie.animate().setDuration(2000).setStartDelay(2900);
        appname.animate().setDuration(2000).setStartDelay(2900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),SignIn.class);
                startActivity(i);
            }
        },3000);
    }
}