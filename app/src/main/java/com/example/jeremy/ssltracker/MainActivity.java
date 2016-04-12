package com.example.jeremy.ssltracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
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

        displayData.add(new WebTrackerData("www.google.ca", new GregorianCalendar(2016, 05, 17), "SSL"));
        displayData.add(new WebTrackerData("www.amazon.ca", new GregorianCalendar(2016,06,17), "SSL"));
        displayData.add(new WebTrackerData("www.ebay.ca", new GregorianCalendar(2016, 06, 01), "SSL"));
        displayData.add(new WebTrackerData("www.georgiancollege.ca", new GregorianCalendar(2016, 04, 12), "SSL"));
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
        displayData.add(new WebTrackerData("www.facebook.com", new GregorianCalendar(2016,07,17), "SSL"));


        for(WebTrackerData temp : displayData){
            WebTrackerView w = new WebTrackerView(this.getApplicationContext(), null);
            w.updateViewData(temp);

            TableRow r = new TableRow(this.getApplicationContext(), null);
            r.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

            TableLayout t = (TableLayout) findViewById(R.id.mainTableLayout);

            t.addView(r);
            r.addView(w);


        }


    }
}

