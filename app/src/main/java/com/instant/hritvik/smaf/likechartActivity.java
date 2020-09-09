package com.instant.hritvik.smaf;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class likechartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likechart);
        PieChart pieChart = findViewById(R.id.piechart);

        ArrayList<PieEntry> likes = new ArrayList<>();
        likes.add(new PieEntry(500,2015));
        likes.add(new PieEntry(600,2016));
        likes.add(new PieEntry(400,2017));
        likes.add(new PieEntry(800,2018));
        likes.add(new PieEntry(200,2019));

        PieDataSet pieDataSet = new PieDataSet(likes,"Likes per Year");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Likes");
        pieChart.animate();

    }
}
