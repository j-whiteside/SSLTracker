package com.example.jeremy.ssltracker;

import java.util.Date;

/**
 * Created by Jeremy on 4/11/2016.
 */
public class WebTrackerData
{
    private String name;
    private Date renewal;
    private String type;

    public WebTrackerData(String name, Date renewal, String type)
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

    public Date getRenewal() {
        return renewal;
    }

    public void setRenewal(Date renewal) {
        this.renewal = renewal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
