package com.example.jeremy.ssltracker;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Jeremy on 4/11/2016.
 */
public class WebTrackerData implements Serializable
{
    private String name;
    private GregorianCalendar renewal;
    private String type;

    public WebTrackerData(String name, GregorianCalendar renewal, String type)
    {
        this.name = name;
        this.renewal = renewal;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GregorianCalendar getRenewal() {
        return renewal;
    }

    public void setRenewal(GregorianCalendar renewal) {
        this.renewal = renewal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
