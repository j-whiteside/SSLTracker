package com.example.jeremy.ssltracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    //Array

    //List View: {views:items.xml}
    ArrayList<WebTrackerData> displayData = new ArrayList<>();
    String webTrackerItemName = new String();
    String webTrackerItemType = new String();
    GregorianCalendar webTrackerItemDate = new GregorianCalendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
                startActivity(updateIntent);
            }
        });

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

        for(final WebTrackerData temp : displayData){
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

            w.getButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent updateIntent = new Intent(MainActivity.this, UpdateActivity.class);
                    updateIntent.putExtra("object", temp);

                    //updateIntent.putExtra("webTrackerItem", temp);
                    startActivity(updateIntent);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
