package com.example.jeremy.ssltracker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;

import android.widget.TableLayout;
import android.widget.TableRow;


public class MainActivity extends AppCompatActivity {
    //Array

    //List View: {views:items.xml}
    ArrayList<WebTrackerData> displayData = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayData.add(new WebTrackerData("www.google.ca", new GregorianCalendar(2016, 04, 17), "SSL"));
        displayData.add(new WebTrackerData("www.amazon.ca", new GregorianCalendar(2016,04,19), "SSL"));
        displayData.add(new WebTrackerData("www.ebay.ca", new GregorianCalendar(2016, 05, 01), "SSL"));
        displayData.add(new WebTrackerData("www.georgiancollege.ca", new GregorianCalendar(2016, 05, 12), "SSL"));
        displayData.add(new WebTrackerData("www.facebook.com", new GregorianCalendar(2016,07,17), "SSL"));
        displayData.add(new WebTrackerData("www.google.ca", new GregorianCalendar(2016, 05, 17), "SSL"));
        displayData.add(new WebTrackerData("www.amazon.ca", new GregorianCalendar(2016,06,17), "SSL"));
        displayData.add(new WebTrackerData("www.ebay.ca", new GregorianCalendar(2016,06,01), "SSL"));
        displayData.add(new WebTrackerData("www.georgiancollege.ca", new GregorianCalendar(2016,04,12), "SSL"));
        displayData.add(new WebTrackerData("www.facebook.com", new GregorianCalendar(2016,07,17), "SSL"));
        displayData.add(new WebTrackerData("www.google.ca", new GregorianCalendar(2016, 05, 17), "SSL"));
        displayData.add(new WebTrackerData("www.amazon.ca", new GregorianCalendar(2016,06,17), "SSL"));
        displayData.add(new WebTrackerData("www.ebay.ca", new GregorianCalendar(2016,06,01), "SSL"));
        displayData.add(new WebTrackerData("www.georgiancollege.ca", new GregorianCalendar(2016,04,12), "SSL"));
        displayData.add(new WebTrackerData("www.facebook.com", new GregorianCalendar(2016, 07, 17), "SSL"));

        boolean colourSwap = false;



        for(WebTrackerData temp : displayData){
            WebTrackerView w = new WebTrackerView(this.getApplicationContext(), null);

            if (colourSwap) {
                w.setBackgroundColor(Color.parseColor("#f5f5f0"));
            }
            else {
                w.setBackgroundColor(Color.parseColor("#e0e0d1"));
            }

            colourSwap = !colourSwap;

            w.updateViewData(temp);

            TableRow r = new TableRow(this.getApplicationContext(), null);
            r.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

            TableLayout t = (TableLayout) findViewById(R.id.mainTableLayout);

            t.addView(r);
            r.addView(w);


        }
    }
}

