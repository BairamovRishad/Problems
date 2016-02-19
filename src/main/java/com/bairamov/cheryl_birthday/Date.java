package com.bairamov.cheryl_birthday;

public class Date {
    private int day;
    private int month;

    public Date(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public static Date valueOf(int day, int month) {
        return new Date(day, month);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Date date = (Date) o;

        return day == date.day && month == date.month;
    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        return result;
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                '}';
    }
}
