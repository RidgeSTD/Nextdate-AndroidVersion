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

    @Override
    public int hashCode() {
        return solarDay+solarMonth+solarYear;
    }

    @Override
    public boolean equals(Object obj) {
        return solarDay == ((Solar) obj).solarDay && solarMonth == ((Solar) obj).solarMonth && solarYear == ((Solar) obj).solarYear;
    }

    @Override
    public String toString() {
        return "阳历" + solarYear + solarMonth + solarDay;
    }
}
