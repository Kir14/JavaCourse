package modules.six.cosmodrome.shuttles;

/*
Создаем класс Шатл. Шатл реализует интерфейс IStart.
 • В методе предстартовой проверки генерируем случайное число в диапазоне от 0 до 10.
Если сгенерированное число больше 3-х то проверка прошла успешно. Если нет - не успешно.
 • В методе запуска двигателей выводим строку в консоль
 «Двигатели Шатла запущены. Все системы в норме.»
 • В методе старт выводим строку в консоль. «Старт Шатла»
 */

public class Shuttle implements IStart {

    @Override
    public boolean checkSystems() {
        return 3 < (int) (Math.random() * 11);
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели Шатла запущены. Все системы в норме.");
    }

    @Override
    public void launch() {
        System.out.println("Старт Шатла");
    }
}
