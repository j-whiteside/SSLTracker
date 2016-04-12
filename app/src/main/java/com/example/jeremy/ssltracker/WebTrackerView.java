package com.example.jeremy.ssltracker;

/**
 * Created by Jeremy on 4/11/2016.
 */
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WebTrackerView extends Button
{
    public WebTrackerView(Context context, AttributeSet attributes)
    {
        super(context, attributes);
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setTextColor(Color.BLACK);
    }

    public void updateViewData(WebTrackerData data)
    {
        GregorianCalendar currentDate = new GregorianCalendar();

        long diff = data.getRenewal().getTimeInMillis() - currentDate.getTimeInMillis();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        this.setText(data.getType() + " : " + data.getName() + " : " + (diffDays > 99 ? "99+" : diffDays) + "d");
    }


}

