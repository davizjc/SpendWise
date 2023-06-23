package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final long DELAY_TIME = 3000; // 3 seconds delay
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the login_signup activity after the delay
                Intent intent = new Intent(MainActivity.this, login_signup.class);
                startActivity(intent);
//                finish(); // Optional: Call finish() to close the MainActivity if you don't want to go back to it
            }
        }, DELAY_TIME);


    }

    public void onScreenClick(View view) {
        Intent intent = new Intent(getApplicationContext(), login_signup.class);
        startActivity(intent);
    }
}