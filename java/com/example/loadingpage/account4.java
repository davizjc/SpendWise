package com.example.loadingpage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class account4 extends AppCompatActivity {
    private Button button;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account4);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }
        // button = findViewById(R.id.button);
        imageButton = findViewById(R.id.backbutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),account1.class);
                startActivity(intent);
            }
        });
        //navbar button
        {
            imageButton2 = findViewById(R.id.tran_nav);
            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), landingpagelastmonth2.class);
                    startActivity(intent);
                }
            });
            imageButton3 = findViewById(R.id.bud_nav);
            imageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),budget1.class);
                    startActivity(intent);
                }
            });
            imageButton4 = findViewById(R.id.home_nav);
            imageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), landingpagelastmonth2.class);
                    startActivity(intent);
                }
            });
            imageButton5 = findViewById(R.id.rep_nav);
            imageButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),Report1.class);
                    startActivity(intent);
                }
            });
            imageButton6 = findViewById(R.id.acc_nav);
            imageButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),account1.class);
                    startActivity(intent);
                }
            });
        }

    }
}