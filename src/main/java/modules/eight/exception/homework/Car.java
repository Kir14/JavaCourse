package modules.eight.exception.homework;

/*
- Создать класс Car c полями (марка, скорость, цена), конструкторы (с
параметрами и default) гетеры-сетеры.

 Создать метод старт в котором пытаетесь завести автомобиль.
 В методе старт генерируете случайное число от 0 до 20, если полученное число оказалось
четным, то выбрасываете созданное ранее вами исключение и передаете его к
месту откуда вызывали метод старт. Если все хорошо и исключение не
вылетело, то выводить в консоль сообщение что автомобиль с такой-то маркой
завелся
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Car {
    private String model;
    private int speed;
    private double price;

    public void start() throws CarException {
        if ((int) (Math.random() * 21) % 2 == 0) {
            throw new CarException(model + " не завелась");
        }
    }

    @Override
    public String toString() {
        return "Автомобиль " + model + " макс скорость " + speed + " км/ч, цена " + price + " BYN";
    }
}
