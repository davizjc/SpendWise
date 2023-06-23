package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUp1 extends AppCompatActivity {
    private EditText name, email, pass;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }
        name = findViewById(R.id.textbox_name);
        email = findViewById(R.id.textbox_email);
        pass = findViewById(R.id.textbox_password);

        button = findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String userpass = pass.getText().toString();

                Intent intent = new Intent(getApplicationContext(),SelectCurrency1.class);
                intent.putExtra("keyname", username);
                intent.putExtra("keyemail", useremail);
                intent.putExtra("keypass", userpass);
                startActivity(intent);
            }
        });
    }
}