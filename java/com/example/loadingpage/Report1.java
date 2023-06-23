package com.example.loadingpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class Report1 extends AppCompatActivity {

    PieChart pieChartIncome;
    PieChart pieChartExpense;
    BarChart barChart;

    //these buttons are for navbar
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;

    //TODO:
    // get all categories and all spending ON THAT MONTH
    // itemsIncomeCategory and itemsIncomeAmount will be used for pie charts
    String[] itemsIncomeCategory = {"Salary", "Bonus", "Lottery"}; //get income categories
    String[] itemsIncomeAmount = {"2000", "35", "500"}; // get income amount for the categories above ON THAT MONTH
    String[] itemsExpenseCategory = {"Transport", "Food", "Entertainment"}; //get expense categories
    String[] itemsExpenseAmount = {"20", "35", "50"}; // get expense amount for the categories above ON THAT MONTH
    String[] itemsMonthlyAmount = {"2000", "3500", "5000"}; // this denotes the monthly spending
    int a = 20;
    int b = 35;
    int c = 50;
    int total = a + b + c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(Color.parseColor("#000000")); // Replace #FF0000 with your desired color
        }
        pieChartIncome = findViewById(R.id.report_pie_chart_income);
        pieChartExpense = findViewById(R.id.report_pie_chart_expense);
        barChart = findViewById(R.id.report_bar_chart_expense);

        initiatePieCharts();
        initiateBarChart();

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

    private void initiatePieCharts() {
        List<PieEntry> incomeEntries = new ArrayList<>();

        //TODO: again, using for loop is advised
        incomeEntries.add(new PieEntry(a, "Transport"));
        incomeEntries.add(new PieEntry(b, "Food"));
        incomeEntries.add(new PieEntry(c, "Entertainment"));

        PieDataSet incomeDataSet = new PieDataSet(incomeEntries, "");
        incomeDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        incomeDataSet.setValueTextSize(9f);
        incomeDataSet.setValueFormatter(new PercentValueFormatter());

        PieData incomeData = new PieData(incomeDataSet);
        incomeData.setValueTextColor(Color.BLACK);

        pieChartIncome.setData(incomeData);
        pieChartIncome.getDescription().setEnabled(false);
        pieChartIncome.setDrawEntryLabels(false);

        pieChartIncome.animateY(1500, Easing.EaseInOutQuad); // Animate the chart

        pieChartIncome.invalidate(); // Refresh the chart

        // Create expense entries (dummy data)
        List<PieEntry> expenseEntries = new ArrayList<>();
        //TODO: again, using for loop is advised
        expenseEntries.add(new PieEntry(10f, "Salary"));
        expenseEntries.add(new PieEntry(15f, "Bonus"));
        expenseEntries.add(new PieEntry(20f, "Lottery"));

        // Create the expense data set
        PieDataSet expenseDataSet = new PieDataSet(expenseEntries, "");
        expenseDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        expenseDataSet.setValueTextSize(9f);
        expenseDataSet.setValueFormatter(new PercentValueFormatter());

        // Create the expense data object
        PieData expenseData = new PieData(expenseDataSet);
        expenseData.setValueTextColor(Color.BLACK);

        pieChartExpense.setData(expenseData);
        pieChartExpense.getDescription().setEnabled(false);
        pieChartExpense.setDrawEntryLabels(false);

        pieChartExpense.animateY(1500, Easing.EaseInOutQuad); // Animate the chart

        pieChartExpense.invalidate(); // Refresh the chart
    }


    private void initiateBarChart() {
        List<BarEntry> barEntries = new ArrayList<>();
        //TODO:
        // get monthly expense, x values denotes month, y values denotes expense amount on that month
        // i also suggest using for loop and itemMonthlyAmount
        barEntries.add(new BarEntry(1, 100)); // Month 1, expense amount 100
        barEntries.add(new BarEntry(2, 200)); // Month 2, expense amount 200
        barEntries.add(new BarEntry(3, 150)); // Month 3, expense amount 150
        // Add more entries for the remaining months

        BarDataSet barDataSet = new BarDataSet(barEntries, "Monthly Expenses");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        BarData barData = new BarData(barDataSet);
        barData.setValueTextSize(12f);
        barData.setBarWidth(0.9f);

        barChart.setData(barData);
        barChart.getDescription().setEnabled(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new MonthAxisValueFormatter());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setAxisMinimum(0.5f);
        xAxis.setAxisMaximum(12.5f);
        xAxis.setLabelCount(12);

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setAxisMinimum(0f);

        YAxis yAxisRight = barChart.getAxisRight();
        yAxisRight.setEnabled(false);

        barChart.animateY(1500, Easing.EaseInOutQuad); // Animate the chart

        barChart.invalidate(); // Refresh the chart
    }

    private class PercentValueFormatter extends ValueFormatter {
        @Override
        public String getFormattedValue(float value) {
            return String.format("%.1f%%", value * 100 / total);
        }
    }

    private class MonthAxisValueFormatter extends ValueFormatter {
        private final String[] monthLabels = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        @Override
        public String getAxisLabel(float value, AxisBase axis) {
            int month = (int) value;
            if (month >= 1 && month <= 12) {
                return monthLabels[month - 1];
            } else {
                return "";
            }
        }
    }

    public void onIncomeClick(View view) {
        Intent intent = new Intent(getApplicationContext(), IncomeStat1.class);
        startActivity(intent);
    }

    public void onExpenseClick(View view) {
        Intent intent = new Intent(getApplicationContext(), ExpenseStat1.class);
        startActivity(intent);
    }
}
