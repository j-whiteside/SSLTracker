package com.example.jeremy.ssltracker;

/**
 * Created by Jeremy on 4/11/2016.
 */
import android.content.Context;
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
    TextView text;

    public WebTrackerView(Context context, AttributeSet attributes)
    {
        super(context, attributes);

        /*text = new TextView(context);
        text.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        text.setText("ASDF text");
        this.addView(text);*/

        button = new Button(context);
        button.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        //button.setText("ASDF BUTTON");
        this.addView(button);

        //text.bringToFront();
        button.invalidate();
    }

    public void updateViewData(WebTrackerData data)
    {
        GregorianCalendar now = new GregorianCalendar();

        long diffDays = 0;

        button.setText(data.getType() + " : " + data.getName() + " : " + (diffDays > 99 ? "99+" : diffDays) + "d");
    }


}

