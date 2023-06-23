package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.loadingpage.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ExpenseStat1 extends AppCompatActivity {
    PieChart pieChart;
    ListView listView;
    //TODO:
    // get all categories and all spending
    // these categories amount will later on be used for pie chart and listView
    String[] itemsCategory = {"Transport", "Food", "Entertainment"}; //get categories
    String[] itemsAmount = {"20", "35", "50"}; // get categories amount

    int a = 20; //
    int b = 35;
    int c = 50;
    int total = a+b+c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_stat1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }

        pieChart = findViewById(R.id.report_pie_chart);
        listView = findViewById(R.id.report_list_view);
//        adapterCategory = new ArrayAdapter<>(this, R.layout.category_item, R.id.listCategory, itemsCategory);
//        adapterAmount = new ArrayAdapter<>(this, R.layout.category_item, R.id.listCategory, itemsCategory);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        initiatePieChart();
    }

    void initiatePieChart() {
        List<PieEntry> entries = new ArrayList<>();
        //TODO: you can use a for loop to make the entries below (first param denotes the value, second is label for the value)
        // i suggest using a for loop and itemsCategory and itemsAmount array to input all the data
        entries.add(new PieEntry(a, "Transport"));
        entries.add(new PieEntry(b, "Entertainment"));
        entries.add(new PieEntry(c, "Food"));

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextSize(12f);
        dataSet.setValueFormatter(new PercentValueFormatter());

        PieData data = new PieData(dataSet);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);
        pieChart.getDescription().setEnabled(false);

        pieChart.animateY(1500, Easing.EaseInOutQuad); // Animate the chart

        pieChart.invalidate(); // Refresh the chart
    }

    private class PercentValueFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {
            return String.format("%.1f%%", value*100/total );
        }
    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return itemsAmount.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.category_item,null);
            TextView category = view1.findViewById(R.id.listCategory);
            TextView amount = view1.findViewById(R.id.listAmount);
            category.setText(itemsCategory[position]);
            amount.setText(itemsAmount[position]);

            return view1;
        }
    }

    public void onBackClick(View view) {
        Intent intent = new Intent(getApplicationContext(), Report1.class);
        startActivity(intent);
    }
}
