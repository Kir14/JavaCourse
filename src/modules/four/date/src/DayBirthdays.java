package modules.four.date.src;

/*
Напишите программу, которая покажет прошедшие дни вашего рождения от нуля лет до текущего времени в формате: возраст, дата и день недели.
Дату рождения задавайте используя три переменные:
int day = 31;
int month = 12;
int year = 1990;

Формат требуемого вывода:
    0 - 31.12.1990 - Mon
    1 - 31.12.1991 - Tue
    …

 */

public class DayBirthdays {
    public static void main(String[] args) {
        MyDate date = new MyDate(20, 11, 2000);
        date.outputDays();

    }
}
