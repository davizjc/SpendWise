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

public class BudgetExpense1 extends AppCompatActivity {

    //these buttons are for navbar
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    //TODO:
//    String categoryName = get the name of the category which user picks
//    int budget = get the budget for the category
//    int totalAmount = get category spending
//    int leftToSpend = budget - totalSpending;
//    int recommended spending  = ? idk wht u guys mean with these so i'll leave it blank
//    int dailySpendng = ?
//    int categoryIcon = get icon for category

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_expense1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }

        //these are the textboxes that you can change
        ImageView categoryIcon = findViewById(R.id.budget_category_icon);
        TextView categoryText = findViewById(R.id.budget_category_name);
        TextView budgetText = findViewById(R.id.budget_category_amount);
        TextView totalAmountText = findViewById(R.id.budget_total_amount);
        TextView leftToSpendText = findViewById(R.id.budget_left_amount);
        TextView recommendedText = findViewById(R.id.budget_recommended_amount);
        TextView dailySpendngText = findViewById(R.id.budget_daily_amount);

//        TODO:
//        replace the text with the integers
//        ex:
//        categoryIcon.setImageResource(categoryIcon)
//        categoryText.setText(categoryName);
//        budgetText.setText(Integer.toString(budget));
//        and so on

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
        Intent intent = new Intent(getApplicationContext(), budget1.class);
        startActivity(intent);
    }
}