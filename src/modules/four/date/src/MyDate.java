package modules.four.date.src;

import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Locale;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void outputDays() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE", Locale.getDefault());
        for (int i = year; i <= Year.now().getValue(); i++) {
            calendar.set(i, month - 1, day);
            System.out.println((i - year) + " - " + sdfDate.format(calendar.getTime()) + " - " + sdfDay.format(calendar.getTime()));
        }
    }

    @Override
    public String toString() {
        return "Date: " + day + "." + month + "." + year + ".";
    }
}
