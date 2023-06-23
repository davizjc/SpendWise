package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;

public class AddBudget2 extends AppCompatActivity {
    Button buttonCreateBudget;
    String[] itemsRepeat = {"Daily", "Weekly", "Monthly", "Yearly"};
    String[] itemsIcon = {":)", ":(", ">_<", "B)"}; //TODO: Get icons
    String[] itemsCategory = {"Transport", "Food", "Entertainment"}; //TODO: Get categories

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget2);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }

        //choosing category spinner, itemsCategory will later on be integrated with back end
        Spinner spinnerCategory = findViewById(R.id.budget_spinner_category);
        ArrayAdapter<String> adapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemsCategory);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemsCategory[position];
                //TODO: Handle the selected item here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Handle the case when nothing is selected
            }
        });

        //choosing icon spinner
        Spinner spinnerIcon = findViewById(R.id.budget_spinner_icon);
        ArrayAdapter<String> adapterIcon = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemsIcon);
        adapterIcon.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIcon.setAdapter(adapterIcon);

        spinnerIcon.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemsIcon[position];
                //TODO: Handle the selected item here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Handle the case when nothing is selected
            }
        });

        //repeat weekly, monthly, or yearly selection spinner
        Spinner spinnerRepeat = findViewById(R.id.budget_spinner_repeat);
        ArrayAdapter<String> adapterRepeat = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itemsRepeat);
        adapterRepeat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRepeat.setAdapter(adapterRepeat);

        spinnerRepeat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemsRepeat[position];
                //TODO: Handle the selected item here
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //TODO: Handle the case when nothing is selected
            }
        });

        buttonCreateBudget = findViewById(R.id.budget_button_create_budget);
        buttonCreateBudget.setOnClickListener(new View.OnClickListener(){
            //TODO: handle create budget request
            @Override
            public void onClick (View v){
                Intent intent = new Intent(getApplicationContext(), budget1.class);
                startActivity(intent);
            }
        });
    }


    public void onBackClick(View view) {
        Intent intent = new Intent(getApplicationContext(), budget1.class);
        startActivity(intent);
    }
}
