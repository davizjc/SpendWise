package com.example.loadingpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import org.json.JSONException;
import org.json.JSONObject;


public class SelectCurrency1 extends AppCompatActivity {
    private Button button;
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    String username, useremail, userpass;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_currency);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }

        SearchView searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Search Currency");

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            username = acct.getDisplayName();
            useremail = acct.getEmail();
            userpass = acct.getIdToken();
        } else {
            username = getIntent().getStringExtra("keyname");
            useremail = getIntent().getStringExtra("keyemail");
            userpass = getIntent().getStringExtra("keypass");
        }

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createNewAcc();
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), ".", Toast.LENGTH_SHORT).show();
                }
            }
        });


        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);



        resetBackgroundColors();

        // Set OnClickListener for each ImageButton
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColors();
                // Change background color to red for the clicked ImageButton
                imageButton1.setBackgroundColor(Color.parseColor("#F4BBBB"));
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColors();
                // Change background color to red for the clicked ImageButton
                imageButton2.setBackgroundColor(Color.parseColor("#F4BBBB"));
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColors();
                // Change background color to red for the clicked ImageButton
                imageButton3.setBackgroundColor(Color.parseColor("#F4BBBB"));
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColors();
                // Change background color to red for the clicked ImageButton
                imageButton4.setBackgroundColor(Color.parseColor("#F4BBBB"));
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColors();
                // Change background color to red for the clicked ImageButton
                imageButton5.setBackgroundColor(Color.parseColor("#F4BBBB"));
            }
        });

        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackgroundColors();
                // Change background color to red for the clicked ImageButton
                imageButton6.setBackgroundColor(Color.parseColor("#F4BBBB"));
            }
        });

        // Method to reset the background color of all ImageButtons

    }

    void createNewAcc() throws JSONException {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://3.26.8.73:3306/register";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", useremail);
        jsonObject.put("username", username);
        jsonObject.put("password", userpass);
        Log.e("TAG", jsonObject.toString());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                userpass = response.toString().trim();
                Log.e("TAG", response.toString());
                Toast.makeText(getApplicationContext(), userpass, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "No response");
                Toast.makeText(getApplicationContext(), "hm", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
        Intent intent = new Intent(getApplicationContext(), landingpagelastmonth2.class);
        startActivity(intent);
    }
    void resetBackgroundColors() {
        imageButton1.setBackgroundColor(Color.TRANSPARENT);
        imageButton2.setBackgroundColor(Color.TRANSPARENT);
        imageButton3.setBackgroundColor(Color.TRANSPARENT);
        imageButton4.setBackgroundColor(Color.TRANSPARENT);
        imageButton5.setBackgroundColor(Color.TRANSPARENT);
        imageButton6.setBackgroundColor(Color.TRANSPARENT);
    }
}