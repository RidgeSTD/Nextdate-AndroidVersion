package com.daggerstudio.lunar.util;

/**
 * Created by alex on 15/4/9.
 */
public class Solar {
    public int solarDay;
    public int solarMonth;
    public int solarYear;
    public  Solar(){}

    public Solar(int year, int month, int day){
        this.solarDay = day;
        this.solarMonth = month;
        this.solarYear = year;
    }
}
