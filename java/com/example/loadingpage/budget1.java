package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class budget1 extends AppCompatActivity {

    ListView listView;
    Button buttonNewBudget;
    //these buttons are for navbar
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    //array of category budget
    int[] itemsCategoryIcon = {R.drawable.transport, R.drawable.food_drinks, R.drawable.entertainment};//TODO: get categories icons
    String[] itemsCategoryName = {"Transport", "Food", "Entertainment"}; //TODO: Get all categories that have budgets
    String[] itemsCategoryMonthlyBudget = {"2910", "5000", "1000"}; //TODO: get the monthly budget for those categories
    String[] itemsCategoryCurrentSpending = {"2425", "1000", "900"}; //TODO: get the current spending for those categories

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }


        listView = findViewById(R.id.budget_list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        buttonNewBudget = findViewById(R.id.budget_button_new_category);
        buttonNewBudget.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getApplicationContext(), AddBudget2.class);
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

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return itemsCategoryName.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.budget_item,null);
            ImageView categoryIcon = view1.findViewById(R.id.budget_list_category_icon);
            TextView categoryName = view1.findViewById(R.id.budget_list_category_name);
            ProgressBar progressBar = view1.findViewById(R.id.budget_list_category_progress_bar);
            TextView categoryMonthlyBudget = view1.findViewById(R.id.budget_list_monthly_budget_amount);
            TextView categoryLeftSpending = view1.findViewById(R.id.budget_list_left_spend_amount);

            int categoryCurrentSpending_int = Integer.parseInt(itemsCategoryCurrentSpending[position]);
            int categoryMonthlyBudget_int = Integer.parseInt(itemsCategoryMonthlyBudget[position]);
            int categoryLeftSpending_int = categoryMonthlyBudget_int - categoryCurrentSpending_int;

            categoryIcon.setImageResource(itemsCategoryIcon[position]);
            categoryName.setText(itemsCategoryName[position]);
            categoryMonthlyBudget.setText("$ " + itemsCategoryMonthlyBudget[position]);
            categoryLeftSpending.setText("$ " + Integer.toString(categoryLeftSpending_int));

            int progress =  categoryCurrentSpending_int*100 / categoryMonthlyBudget_int;
            progressBar.setProgress(progress);

            return view1;
        }
    }
}