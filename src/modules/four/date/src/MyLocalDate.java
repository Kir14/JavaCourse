package modules.four.date.src;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.text.*;

public class MyLocalDate {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        System.out.println(LocalDate.of(2023, 8, 3));
        System.out.println(LocalDateTime.of(LocalDate.of(2023, 12, 21), LocalTime.now()));

        LocalDate nowD = LocalDate.now();
        LocalDate plusDays = nowD.plusDays(2);
        LocalDate minusWeek = nowD.minusWeeks(1);
        LocalDate plusMonths = nowD.plusMonths(3);
        System.out.println(plusDays);
        System.out.println(plusMonths);
        System.out.println(minusWeek);

        System.out.println(nowD.isAfter(minusWeek));
        System.out.println(plusDays.isBefore(nowD));

        System.out.println(nowD.compareTo(plusDays));
        System.out.println(nowD.compareTo(LocalDate.of(2024,11,21)));
        System.out.println(nowD.compareTo(minusWeek));

        LocalDateTime nowDT = LocalDateTime.now();
        String rfcFormat = nowDT.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy hh:mm:ss"));
        System.out.println(rfcFormat);
        System.out.println(nowDT.format(DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy HH:mm:ss")));


        ZoneId zone = ZoneId.of("Europe/Minsk");
        ZonedDateTime minskTime = ZonedDateTime.of(nowDT.toLocalDate(), nowDT.toLocalTime(), zone);
        System.out.println(minskTime);
        ZonedDateTime colTime = minskTime.withZoneSameInstant(ZoneId.of("Asia/Colombo"));
        ZonedDateTime japanTime = minskTime.withZoneSameInstant(ZoneOffset.of("-09:00"));

        System.out.println(colTime);
        System.out.println(japanTime);

        List<String> zones = new ArrayList<>(ZoneId.getAvailableZoneIds());
        zones.forEach(System.out::println);

        Period period = Period.of(1, 15, 60);
        System.out.println(period);
        System.out.println(period.normalized());

        LocalDate pPlus = nowD.plus(period);
        System.out.println(pPlus);

        Duration duration = Duration.between(LocalTime.now(), LocalTime.now().plusHours(2));
        System.out.println(duration);

        System.out.println(ChronoUnit.DAYS.between(nowD, plusMonths));

        TemporalAdjuster fourthSunday = TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.SUNDAY);
        System.out.println(nowD.with(fourthSunday));

        TemporalAdjuster firstDayOfNextYear = TemporalAdjusters.firstDayOfNextYear();
        System.out.println(nowD.with(firstDayOfNextYear));


    }
}
