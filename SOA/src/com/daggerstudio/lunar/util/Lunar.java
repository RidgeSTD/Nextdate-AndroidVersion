package com.daggerstudio.lunar.util;

/**
 * Created by alex on 15/4/9.
 */
public class Lunar {
    public boolean isleap;
    public int lunarDay;
    public int lunarMonth;
    public int lunarYear;

    public Lunar(int lunarYear, int lunarMonth, int lunarDay, boolean isleap) {
        this.lunarYear = lunarYear;
        this.lunarMonth = lunarMonth;
        this.lunarDay = lunarDay;
        this.isleap = isleap;
    }
    public Lunar(){
        super();
    }
    @Override
    public int hashCode() {
        return lunarDay+lunarMonth+lunarYear;
    }

    @Override
    public boolean equals(Object obj) {
        return lunarDay == ((Lunar) obj).lunarDay && lunarMonth == ((Lunar) obj).lunarMonth && lunarYear == ((Lunar) obj).lunarYear;
    }

    @Override
    public String toString() {
        return "阴历" + lunarYear + lunarMonth + lunarDay;
    }
}
