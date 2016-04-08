package com.example.jeremy.ssltracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    //Array

    //List View: {views:items.xml}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        
    }

    private void populateListView() {
        //Create List of items
        String[] myItems = {"red", "blue", "Google", "Halloran.ca", "amazon.com", "ebay.exe", "microsoft.com", "virus.dll", "telusapp.com/patrick", "meatspin.com", "red", "blue", "Google", "Halloran.ca", "amazon.com", "ebay.exe", "microsoft.com", "virus.dll", "telusapp.com/patrick", "red", "blue", "Google", "Halloran.ca", "amazon.com", "ebay.exe", "microsoft.com", "virus.dll", "telusapp.com/patrick", "red", "blue", "Google", "Halloran.ca", "amazon.com", "ebay.exe", "microsoft.com", "virus.dll", "telusapp.com/patrick", "red", "blue", "Google", "Halloran.ca", "amazon.com", "ebay.exe", "microsoft.com", "virus.dll", "telusapp.com/patrick"};

        //Build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.items, myItems);

        //Config list view
        ListView list = (ListView)findViewById(R.id.listView);
        list.setAdapter(adapter);
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
