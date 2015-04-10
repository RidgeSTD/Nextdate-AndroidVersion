package com.daggerstudio.lunar.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.DateFormatSymbols;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import libcore.icu.ICU;
import libcore.icu.LocaleData;


public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {

    private static final long serialVersionUID = -1807547505821590642L;


    protected boolean areFieldsSet;


    protected int[] fields;


    protected boolean[] isSet;


    protected boolean isTimeSet;


    protected long time;

    transient int lastTimeFieldSet;

    transient int lastDateFieldSet;

    private boolean lenient;

    private int firstDayOfWeek;

    private int minimalDaysInFirstWeek;

    private TimeZone zone;


    public static final int JANUARY = 0;


    public static final int FEBRUARY = 1;


    public static final int MARCH = 2;


    public static final int APRIL = 3;


    public static final int MAY = 4;


    public static final int JUNE = 5;


    public static final int JULY = 6;


    public static final int AUGUST = 7;


    public static final int SEPTEMBER = 8;


    public static final int OCTOBER = 9;


    public static final int NOVEMBER = 10;


    public static final int DECEMBER = 11;


    public static final int UNDECIMBER = 12;


    public static final int SUNDAY = 1;


    public static final int MONDAY = 2;


    public static final int TUESDAY = 3;


    public static final int WEDNESDAY = 4;


    public static final int THURSDAY = 5;


    public static final int FRIDAY = 6;


    public static final int SATURDAY = 7;


    public static final int ERA = 0;


    public static final int YEAR = 1;


    public static final int MONTH = 2;


    public static final int WEEK_OF_YEAR = 3;


    public static final int WEEK_OF_MONTH = 4;


    public static final int DATE = 5;


    public static final int DAY_OF_MONTH = 5;


    public static final int DAY_OF_YEAR = 6;


    public static final int DAY_OF_WEEK = 7;


    public static final int DAY_OF_WEEK_IN_MONTH = 8;


    public static final int AM_PM = 9;


    public static final int HOUR = 10;


    public static final int HOUR_OF_DAY = 11;


    public static final int MINUTE = 12;


    public static final int SECOND = 13;


    public static final int MILLISECOND = 14;


    public static final int ZONE_OFFSET = 15;


    public static final int DST_OFFSET = 16;


    public static final int FIELD_COUNT = 17;


    public static final int AM = 0;


    public static final int PM = 1;


    public static final int ALL_STYLES = 0;


    public static final int SHORT = 1;


    public static final int LONG = 2;

    private static final String[] FIELD_NAMES = { "ERA", "YEAR", "MONTH",
            "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR",
            "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR",
            "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND",
            "ZONE_OFFSET", "DST_OFFSET" };


    protected Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    Calendar(TimeZone timezone) {
        fields = new int[FIELD_COUNT];
        isSet = new boolean[FIELD_COUNT];
        areFieldsSet = isTimeSet = false;
        setLenient(true);
        setTimeZone(timezone);
    }


    protected Calendar(TimeZone timezone, Locale locale) {
        this(timezone);
        locale = LocaleData.mapInvalidAndNullLocales(locale);
        LocaleData localeData = LocaleData.get(locale);
        setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
    }



    public abstract void add(int field, int value);


    public boolean after(Object calendar) {
        if (!(calendar instanceof Calendar)) {
            return false;
        }
        return getTimeInMillis() > ((Calendar) calendar).getTimeInMillis();
    }


    public boolean before(Object calendar) {
        if (!(calendar instanceof Calendar)) {
            return false;
        }
        return getTimeInMillis() < ((Calendar) calendar).getTimeInMillis();
    }


    public final void clear() {
        for (int i = 0; i < FIELD_COUNT; i++) {
            fields[i] = 0;
            isSet[i] = false;
        }
        areFieldsSet = isTimeSet = false;
    }


    public final void clear(int field) {
        fields[field] = 0;
        isSet[field] = false;
        areFieldsSet = isTimeSet = false;
    }


    @Override
    public Object clone() {
        try {
            Calendar clone = (Calendar) super.clone();
            clone.fields = fields.clone();
            clone.isSet = isSet.clone();
            clone.zone = (TimeZone) zone.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }


    protected void complete() {
        if (!isTimeSet) {
            computeTime();
            isTimeSet = true;
        }
        if (!areFieldsSet) {
            computeFields();
            areFieldsSet = true;
        }
    }


    protected abstract void computeFields();


    protected abstract void computeTime();


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar cal = (Calendar) object;
        return getTimeInMillis() == cal.getTimeInMillis()
                && isLenient() == cal.isLenient()
                && getFirstDayOfWeek() == cal.getFirstDayOfWeek()
                && getMinimalDaysInFirstWeek() == cal.getMinimalDaysInFirstWeek()
                && getTimeZone().equals(cal.getTimeZone());
    }


    public int get(int field) {
        complete();
        return fields[field];
    }


    public int getActualMaximum(int field) {
        int value, next;
        if (getMaximum(field) == (next = getLeastMaximum(field))) {
            return next;
        }
        complete();
        long orgTime = time;
        set(field, next);
        do {
            value = next;
            roll(field, true);
            next = get(field);
        } while (next > value);
        time = orgTime;
        areFieldsSet = false;
        return value;
    }


    public int getActualMinimum(int field) {
        int value, next;
        if (getMinimum(field) == (next = getGreatestMinimum(field))) {
            return next;
        }
        complete();
        long orgTime = time;
        set(field, next);
        do {
            value = next;
            roll(field, false);
            next = get(field);
        } while (next < value);
        time = orgTime;
        areFieldsSet = false;
        return value;
    }


    public static synchronized Locale[] getAvailableLocales() {
        return ICU.getAvailableCalendarLocales();
    }


    public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }


    public abstract int getGreatestMinimum(int field);


    public static synchronized Calendar getInstance() {
        return new GregorianCalendar();
    }


    public static synchronized Calendar getInstance(Locale locale) {
        return new com.daggerstudio.lunar.util.GregorianCalendar(locale);
    }


    public static synchronized Calendar getInstance(TimeZone timezone) {
        return new GregorianCalendar(timezone);
    }


    public static synchronized Calendar getInstance(TimeZone timezone, Locale locale) {
        return new GregorianCalendar(timezone, locale);
    }


    public abstract int getLeastMaximum(int field);


    public abstract int getMaximum(int field);


    public int getMinimalDaysInFirstWeek() {
        return minimalDaysInFirstWeek;
    }


    public abstract int getMinimum(int field);


    public final Date getTime() {
        return new Date(getTimeInMillis());
    }


    public long getTimeInMillis() {
        if (!isTimeSet) {
            computeTime();
            isTimeSet = true;
        }
        return time;
    }


    public TimeZone getTimeZone() {
        return zone;
    }

    @Override
    public int hashCode() {
        return (isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                + getMinimalDaysInFirstWeek() + getTimeZone().hashCode();
    }


    protected final int internalGet(int field) {
        return fields[field];
    }


    public boolean isLenient() {
        return lenient;
    }


    public final boolean isSet(int field) {
        return isSet[field];
    }


    public void roll(int field, int value) {
        boolean increment = value >= 0;
        int count = increment ? value : -value;
        for (int i = 0; i < count; i++) {
            roll(field, increment);
        }
    }


    public abstract void roll(int field, boolean increment);


    public void set(int field, int value) {
        fields[field] = value;
        isSet[field] = true;
        areFieldsSet = isTimeSet = false;
        if (field > MONTH && field < AM_PM) {
            lastDateFieldSet = field;
        }
        if (field == HOUR || field == HOUR_OF_DAY) {
            lastTimeFieldSet = field;
        }
        if (field == AM_PM) {
            lastTimeFieldSet = HOUR;
        }
    }


    public final void set(int year, int month, int day) {
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, day);
    }


    public final void set(int year, int month, int day, int hourOfDay, int minute) {
        set(year, month, day);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
    }


    public final void set(int year, int month, int day, int hourOfDay, int minute, int second) {
        set(year, month, day, hourOfDay, minute);
        set(SECOND, second);
    }


    public void setFirstDayOfWeek(int value) {
        firstDayOfWeek = value;
    }


    public void setLenient(boolean value) {
        lenient = value;
    }


    public void setMinimalDaysInFirstWeek(int value) {
        minimalDaysInFirstWeek = value;
    }


    public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }


    public void setTimeInMillis(long milliseconds) {
        if (!isTimeSet || !areFieldsSet || time != milliseconds) {
            time = milliseconds;
            isTimeSet = true;
            areFieldsSet = false;
            complete();
        }
    }


    public void setTimeZone(TimeZone timezone) {
        zone = timezone;
        areFieldsSet = false;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName() +
                "[time=" + (isTimeSet ? String.valueOf(time) : "?") +
                ",areFieldsSet=" + areFieldsSet +
                ",lenient=" + lenient +
                ",zone=" + zone.getID() +
                ",firstDayOfWeek=" + firstDayOfWeek +
                ",minimalDaysInFirstWeek=" + minimalDaysInFirstWeek);
        for (int i = 0; i < FIELD_COUNT; i++) {
            result.append(',');
            result.append(FIELD_NAMES[i]);
            result.append('=');
            if (isSet[i]) {
                result.append(fields[i]);
            } else {
                result.append('?');
            }
        }
        result.append(']');
        return result.toString();
    }


    public int compareTo(Calendar anotherCalendar) {
        if (anotherCalendar == null) {
            throw new NullPointerException("anotherCalendar == null");
        }
        long timeInMillis = getTimeInMillis();
        long anotherTimeInMillis = anotherCalendar.getTimeInMillis();
        if (timeInMillis > anotherTimeInMillis) {
            return 1;
        }
        if (timeInMillis == anotherTimeInMillis) {
            return 0;
        }
        return -1;
    }


    public String getDisplayName(int field, int style, Locale locale) {
        // TODO: the RI's documentation says ALL_STYLES is invalid, but actually treats it as SHORT.
        if (style == ALL_STYLES) {
            style = SHORT;
        }
        String[] array = getDisplayNameArray(field, style, locale);
        int value = get(field);
        return (array != null) ? array[value] : null;
    }

    private String[] getDisplayNameArray(int field, int style, Locale locale) {
        if (field < 0 || field >= FIELD_COUNT) {
            throw new IllegalArgumentException("bad field " + field);
        }
        checkStyle(style);
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        switch (field) {
            case AM_PM:
                return dfs.getAmPmStrings();
            case DAY_OF_WEEK:
                return (style == LONG) ? dfs.getWeekdays() : dfs.getShortWeekdays();
            case ERA:
                return dfs.getEras();
            case MONTH:
                return (style == LONG) ? dfs.getMonths() : dfs.getShortMonths();
        }
        return null;
    }

    private static void checkStyle(int style) {
        if (style != ALL_STYLES && style != SHORT && style != LONG) {
            throw new IllegalArgumentException("bad style " + style);
        }
    }


    public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        checkStyle(style);
        complete();
        Map<String, Integer> result = new HashMap<String, Integer>();
        if (style == SHORT || style == ALL_STYLES) {
            insertValuesInMap(result, getDisplayNameArray(field, SHORT, locale));
        }
        if (style == LONG || style == ALL_STYLES) {
            insertValuesInMap(result, getDisplayNameArray(field, LONG, locale));
        }
        return result.isEmpty() ? null : result;
    }

    private static void insertValuesInMap(Map<String, Integer> map, String[] values) {
        if (values == null) {
            return;
        }
        for (int i = 0; i < values.length; ++i) {
            if (values[i] != null && !values[i].isEmpty()) {
                map.put(values[i], i);
            }
        }
    }

    private static final ObjectStreamField[] serialPersistentFields = {
            new ObjectStreamField("areFieldsSet", boolean.class),
            new ObjectStreamField("fields", int[].class),
            new ObjectStreamField("firstDayOfWeek", int.class),
            new ObjectStreamField("isSet", boolean[].class),
            new ObjectStreamField("isTimeSet", boolean.class),
            new ObjectStreamField("lenient", boolean.class),
            new ObjectStreamField("minimalDaysInFirstWeek", int.class),
            new ObjectStreamField("nextStamp", int.class),
            new ObjectStreamField("serialVersionOnStream", int.class),
            new ObjectStreamField("time", long.class),
            new ObjectStreamField("zone", TimeZone.class),
    };

    private void writeObject(ObjectOutputStream stream) throws IOException {
        complete();
        ObjectOutputStream.PutField putFields = stream.putFields();
        putFields.put("areFieldsSet", areFieldsSet);
        putFields.put("fields", this.fields);
        putFields.put("firstDayOfWeek", firstDayOfWeek);
        putFields.put("isSet", isSet);
        putFields.put("isTimeSet", isTimeSet);
        putFields.put("lenient", lenient);
        putFields.put("minimalDaysInFirstWeek", minimalDaysInFirstWeek);
        putFields.put("nextStamp", 2 /* MINIMUM_USER_STAMP */);
        putFields.put("serialVersionOnStream", 1);
        putFields.put("time", time);
        putFields.put("zone", zone);
        stream.writeFields();
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = stream.readFields();
        areFieldsSet = readFields.get("areFieldsSet", false);
        this.fields = (int[]) readFields.get("fields", null);
        firstDayOfWeek = readFields.get("firstDayOfWeek", Calendar.SUNDAY);
        isSet = (boolean[]) readFields.get("isSet", null);
        isTimeSet = readFields.get("isTimeSet", false);
        lenient = readFields.get("lenient", true);
        minimalDaysInFirstWeek = readFields.get("minimalDaysInFirstWeek", 1);
        time = readFields.get("time", 0L);
        zone = (TimeZone) readFields.get("zone", null);
    }
}
