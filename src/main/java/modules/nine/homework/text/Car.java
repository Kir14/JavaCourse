package modules.nine.homework.text;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import modules.eight.exception.homework.CarException;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Car implements Serializable {
    private String model;
    private transient int speed;
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
