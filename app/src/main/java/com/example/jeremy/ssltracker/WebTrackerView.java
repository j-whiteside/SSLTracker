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

public class WebTrackerView extends RelativeLayout
{
    Button button;
    TextView textview;

    public WebTrackerView(Context context, AttributeSet attributes)
    {
        super(context, attributes);

        button = new Button(context);
        textview = new TextView(context);


        button.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        button.setBackground(null);
        button.setTextColor(Color.BLACK);

        this.addView(button);

        //ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        //buttonParams.weight = 1.0f;
        //buttonParams.gravity = Gravity.TOP;

        //button.setLayoutParams(buttonParams);
    }

    public void updateViewData(WebTrackerData data)
    {
        GregorianCalendar currentDate = new GregorianCalendar();

        long diff = data.getRenewal().getTimeInMillis() - currentDate.getTimeInMillis();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        button.setText(data.getType() + " : " + data.getName() + " : " + (diffDays > 99 ? "99+" : diffDays) + "d");
        button.setTextAlignment(TEXT_ALIGNMENT_VIEW_START);
    }


}

