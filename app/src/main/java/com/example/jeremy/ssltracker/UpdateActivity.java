package com.example.jeremy.ssltracker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class UpdateActivity extends AppCompatActivity {

    int dataIndex;
    WebTrackerData data;
    WebTrackerData temp;

    Button saveButton;
    Button cancelButton;
    Button deleteButton;
    TextView nameInputField;
    TextView typeInputField;
    TextView daysRemaining;
    CalendarView calView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Update Item");

        dataIndex = getIntent().getIntExtra("data_index", -999);

        saveButton = (Button) findViewById(R.id.saveButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);



        if (dataIndex == -999)
        {
            Toast.makeText(UpdateActivity.this, "Error: No Object", Toast.LENGTH_SHORT).show();
            returnToMainActivity();
        }
        else if (dataIndex == -1000)
        {
            deleteButton.setEnabled(false);
            data = new WebTrackerData("", new GregorianCalendar(), 0);
        }
        else
        {
            data = MainActivity.serializableData.dataList.get(dataIndex);
        }

        temp = new WebTrackerData(data.getName(), data.getRenewal(), data.getType());

        nameInputField = (EditText) findViewById(R.id.nameInputField);
        nameInputField.setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        daysRemaining = (TextView) findViewById(R.id.daysRemainingLabel);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.WebTrackerOptions, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);


        spinner.setSelection(data.getType());
        nameInputField.setText(data.getName());
        //TO DO
        //set type spinner in dropdown

        calView = (CalendarView) findViewById(R.id.calendarView);
        calView.setDate(data.getRenewal().getTimeInMillis());

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                temp.setRenewal(new GregorianCalendar(year, month, dayOfMonth));
                updateViewData();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMainActivity();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = AskDeleteOption();
                dialog.show();
            }
        });

        updateViewData();
    }

    private void writeSerializableData()
    {
        try(FileOutputStream fs = this.getApplicationContext().openFileOutput("tracker_data_array_06.bin", Context.MODE_PRIVATE))
        {
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(MainActivity.serializableData);

            os.close();
        }
        catch (FileNotFoundException ex)
        {
            Toast.makeText(UpdateActivity.this, "File Not Found", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(UpdateActivity.this, "IO Exception", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveData()
    {
        temp.setName(nameInputField.getText().toString());
        temp.setType(spinner.getSelectedItemPosition());

        if(nameInputField.getText().toString().length() > 0)
        {
            if(dataIndex < 0){
                MainActivity.serializableData.dataList.add(temp);
            } else {
                MainActivity.serializableData.dataList.set(dataIndex, temp);
            }

            writeSerializableData();

            returnToMainActivity();
        }
        else
        {
            AlertDialog dialog = emptyNameOnSave();
            dialog.show();
        }


    }

    public void updateViewData()
    {
        GregorianCalendar currentDate = new GregorianCalendar();
        long diff = temp.getRenewal().getTimeInMillis() - currentDate.getTimeInMillis();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        if(diffDays > 99)
        {
            daysRemaining.setText("99+ days");
            daysRemaining.setTextColor(Color.BLACK);
        }
        else if(diffDays == 1)
        {
            daysRemaining.setText((diffDays) + " day");
            daysRemaining.setTextColor(Color.RED);
        }
        else if (diffDays <= 10 && diffDays >= 0)
        {
            daysRemaining.setText((diffDays) + " days");
            daysRemaining.setTextColor(Color.RED);
        }
        else if(diffDays < 0 )
        {
            daysRemaining.setText("EXPIRED");
            daysRemaining.setTextColor(Color.RED);
        }
        else
        {
            daysRemaining.setText(diffDays + " days");
            daysRemaining.setTextColor(Color.BLACK);
        }
    }

    private void returnToMainActivity()
    {
        Intent mainIntent = new Intent(UpdateActivity.this, MainActivity.class);

        startActivity(mainIntent);
    }

    private AlertDialog AskDeleteOption()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Delete")
                .setMessage("Are you sure you want to delete?")

                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        MainActivity.serializableData.dataList.remove(dataIndex);
                        writeSerializableData();
                        returnToMainActivity();
                        dialog.dismiss();

                    }

                })



                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return myQuittingDialogBox;

    }

    private AlertDialog emptyNameOnSave()
    {
        AlertDialog errorDialogueBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Error")
                .setMessage("You must enter a name.")

                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();
        return errorDialogueBox;

    }

}
