package modules.five.arrays.ambulance;

/*
Что нужно сделать
1.	Создайте массив типа float с температурами 30 пациентов (от 32 до 40 градусов).
2.	Напишите код, который выводит среднюю температуру по больнице и количество здоровых пациентов (с температурой от 36,2 до 36,9), а также температуры всех пациентов.
Вынесите в константы условия задания:
•	количество пациентов,
•	минимальная и максимальная температура пациентов,
•	минимальная и максимальная температура диапазона здоровых пациентов.

Пример
Температуры пациентов: 36.7 38.9 34.7
Средняя температура: 36.76
Количество здоровых: 1

 */

import java.util.stream.Stream;

public class MainAmbulance {
    public static void main(String[] args) {
        /*
        int countPatient = 30;
        float maxTemperature = 40.0f;
        float minTemperature = 32.0f;
        float maxTempGood = 36.9f;
        float minTempGood = 36.2f;
        float[] ambulance = new float[countPatient];
        */

        Ambulance ambulance = new Ambulance(30, 40.0f, 32.0f, 36.9f, 36.2f);
        System.out.println(ambulance);

        System.out.println(ambulance.avgTempStream() + " = " + ambulance.avgTempFor());
        System.out.println(ambulance.countGoodStream() + " = " + ambulance.countGoodFor());


    }




}
