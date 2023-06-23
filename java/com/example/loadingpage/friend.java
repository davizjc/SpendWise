package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class friend extends AppCompatActivity {

    //these buttons are for navbar
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;

    //TODO:
    // - get the name the user clicked
    // - get friend avatar
    // - get friend total expense
    // - get friend's this month expense
    String friendName = "Nellie Valazquez"; //String friendName = getFriendName();
    int friendAvatar = R.drawable.avatar_female;
    String friendTotalExpense = "$ " + "140";
    String friendThisMonth = "$ " + "40";

    // for the expenses record on the bottom of it, ask Karan how it works

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }

        TextView friendsName = findViewById(R.id.acc_friend_name);
        ImageView friendsAvatar = findViewById(R.id.acc_friend_avatar);
        TextView friendsTotalExpense = findViewById(R.id.acc_friend_total_expense);
        TextView friendsThisMonth = findViewById(R.id.acc_friend_this_month);

        friendsName.setText(friendName);
        friendsAvatar.setImageResource(friendAvatar);
        friendsTotalExpense.setText("$ " + friendTotalExpense);
        friendsThisMonth.setText("$ " + friendThisMonth);

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

    public void onBackClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CurrentFriends.class);
        startActivity(intent);
    }
}