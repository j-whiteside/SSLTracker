package com.example.jeremy.ssltracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;

public class UpdateActivity extends AppCompatActivity {

    WebTrackerData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button saveButton = (Button) findViewById(R.id.saveButton);
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        Button deleteButton = (Button) findViewById(R.id.deleteButton);

        TextView nameInputField = (TextView) findViewById(R.id.nameInputField);
        TextView expiryInputField = (TextView) findViewById(R.id.expiryInputField);
        TextView typeInputField = (TextView) findViewById(R.id.typeInputField);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        data = (WebTrackerData) getIntent().getSerializableExtra("object");

        nameInputField.setText(data.getName());
        expiryInputField.setText(data.getRenewal().toString());
        typeInputField.setText(data.getType());
    }

    public void saveData()
    {


    }

}
