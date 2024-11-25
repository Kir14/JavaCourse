package modules.five.arrays.ambulance;

import java.util.Arrays;

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
public class Ambulance {
    private int countPatient = 30;

    private float maxTemperature;
    private float minTemperature;
    private float maxTempGood;
    private float minTempGood;

    double[] ambulance;

    public Ambulance(int countPatient, float maxTemperature, float minTemperature, float maxTempGood, float minTempGood) {
        this.countPatient = countPatient;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
        this.maxTempGood = maxTempGood;
        this.minTempGood = minTempGood;

        ambulance = new double[this.countPatient];
        for (int i = 0; i < ambulance.length; i++) {
            ambulance[i] = rnd(this.minTemperature, this.maxTemperature);
        }
    }

    public double rnd(float min, float max) {
        max -= min;
        return (Math.round(Math.random() * ++max * 10.0) / 10.0) + min;
    }

    /*
    Напишите код, который выводит среднюю температуру
     */
    public double avgTempStream() {
        return Arrays.stream(ambulance).average().getAsDouble();
    }

    public double avgTempFor() {
        double sum = 0;
        for (double temp : ambulance) {
            sum += temp;
        }
        return sum / ambulance.length;
    }

    /*
    Количество здоровых:
     */
    public int countGoodStream() {
        return (int) Arrays.stream(ambulance).filter(w -> w >= minTempGood && w <= maxTempGood).count();
    }

    public int countGoodFor() {
        int count = 0;
        for (double temp : ambulance) {
            if (temp >= minTempGood && temp <= maxTempGood) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Температуры пациентов: ");
        for (double el : ambulance) {
            sb.append(el);
            sb.append(" ");
        }
        sb.append("\n");
        sb.append("Средняя температура: ");
        sb.append(avgTempStream());
        sb.append("\n");
        sb.append("Количество здоровых: ");
        sb.append(countGoodStream());
        return sb.toString();
    }
}
