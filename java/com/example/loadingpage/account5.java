package com.example.loadingpage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class account5 extends AppCompatActivity {
    private Button button;
    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;

    private ImageButton share;
    private ImageButton ig;
    private ImageButton fb;
    private ImageButton tt;
    private ImageButton tw;
    private ImageButton line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account5);
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
    public void onShareClick(View view) {
        String shareText = "Hello, Share this to your friend!";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        Intent chooserIntent = Intent.createChooser(shareIntent, "Share via");
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooserIntent);
        }
    }
    public void onIgClick(View view) {
        String url = "https://www.instagram.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void onFbClick(View view) {
        String url = "https://www.facebook.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void onTwitterClick (View view) {
        String url = "https://twitter.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void onLineClick(View view) {
        String url = "https://line.me/en/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
    public void onTiktokClick(View view) {
        String url = "http://tiktok.com/";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}