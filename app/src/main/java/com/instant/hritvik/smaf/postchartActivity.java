package com.instant.hritvik.smaf;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class postchartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postchart);
        RadarChart radarChart = findViewById(R.id.radarchart);

        ArrayList<RadarEntry> postsviewers1 = new ArrayList<>();
        postsviewers1.add(new RadarEntry(420));
        postsviewers1.add(new RadarEntry(480));
        postsviewers1.add(new RadarEntry(620));
        postsviewers1.add(new RadarEntry(650));
        postsviewers1.add(new RadarEntry(720));

        ArrayList<RadarEntry> postsviewers2 = new ArrayList<>();
        postsviewers2.add(new RadarEntry(320));
        postsviewers2.add(new RadarEntry(580));
        postsviewers2.add(new RadarEntry(20));
        postsviewers2.add(new RadarEntry(950));
        postsviewers2.add(new RadarEntry(1020));

        RadarDataSet radarDataSetforpost1 = new RadarDataSet(postsviewers1, "Post 1");
        radarDataSetforpost1.setColor(Color.RED);
        radarDataSetforpost1.setLineWidth(2f);
        radarDataSetforpost1.setValueTextColor(Color.RED);
        radarDataSetforpost1.setValueTextSize(14f);

        RadarDataSet radarDataSetforpost2 = new RadarDataSet(postsviewers2, "Post 2");
        radarDataSetforpost2.setColor(Color.GREEN);
        radarDataSetforpost2.setLineWidth(2f);
        radarDataSetforpost2.setValueTextColor(Color.GREEN);
        radarDataSetforpost2.setValueTextSize(14f);

        RadarData radarData1 = new RadarData();
        radarData1.addDataSet(radarDataSetforpost1);
        radarData1.addDataSet(radarDataSetforpost2);

        String[] labels = {"2015", "2016", "2017", "2018", "2019"};

        XAxis xAxis1 = radarChart.getXAxis();
        xAxis1.setValueFormatter(new IndexAxisValueFormatter(labels));
        radarChart.setData(radarData1);

        radarChart.getDescription().setText("Radar Chart for Post1");
        radarChart.setData(radarData1);

    }
}
