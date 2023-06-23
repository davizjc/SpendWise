package com.example.loadingpage;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class selectcategory3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectcategory3);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000"));
        }

        Button Button = findViewById(R.id.button_food);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, addrecord1.class);
                startActivity(intent);
            }
        });

        Button Button1 = findViewById(R.id.button_transportation);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, addrecord1.class);
                startActivity(intent);
            }
        });

        Button Button2 = findViewById(R.id.button_other_expenses);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, addrecord1.class);
                startActivity(intent);
            }
        });

        Button Button3 = findViewById(R.id.button_fitness);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, addrecord1.class);
                startActivity(intent);
            }
        });

        Button Button4 = findViewById(R.id.button_fitness);
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, addrecord1.class);
                startActivity(intent);
            }
        });
        Button Button5 = findViewById(R.id.button_streaming_service);
        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, addrecord1.class);
                startActivity(intent);
            }
        });

        Button Button6 = findViewById(R.id.button_new_category);
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(selectcategory3.this, com.example.loadingpage.newcategory4.class);
                startActivity(intent);
            }
        });

    }
}
