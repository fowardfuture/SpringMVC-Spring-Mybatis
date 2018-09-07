package com.action.until;

import java.util.Calendar;

public  class   TimeUtil {
    public static String gettime()
    {
        Calendar calendar=Calendar.getInstance();
        Long date=calendar.getTimeInMillis();
        return date.toString();
    }
    public static boolean cmptime(String date)
    {
        long newdate=Long.parseLong(date);
        Calendar calendar=Calendar.getInstance();
        long nowdate=calendar.getTimeInMillis();
        if (newdate-newdate>60000)
            return false;
        else
            return true;
    }
}
