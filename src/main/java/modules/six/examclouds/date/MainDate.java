package modules.six.examclouds.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainDate {
    public static void main(String[] args) throws ParseException {
        System.out.println(checkDate(Calendar.getInstance().getTime()));
        System.out.println(checkDate(new Date()));
        System.out.println(checkDate(new Date(2024 - 1900, Calendar.DECEMBER, 4, 18, 1, 1)));
        System.out.println(checkDate(new Date(2024 - 1900, Calendar.DECEMBER, 4, 19, 0, 0)));
        System.out.println(checkDate(new Date(2024 - 1900, Calendar.DECEMBER, 4, 19, 1, 1)));
    }

    public static Date checkDate(Date date) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 19);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date now = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (now.after(date)) {
            return formatter.parse(formatter.format(date));
        } else {
            calendar.add(Calendar.DATE, 1);
            return formatter.parse(formatter.format(calendar.getTime()));
        }
    }
}
