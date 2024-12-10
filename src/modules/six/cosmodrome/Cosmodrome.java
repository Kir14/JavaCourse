package modules.six.cosmodrome;

/*
Создаем класс Космодром. В классе создаем метод:
 • запуск
 Метод запуск принимает объект типа IStart.
 В методе первым делом осуществляем предстартовую проверку переданного объекта,
 если она провалилась(метод вернул false) выводим сообщение
  «Предстартовая проверка провалена».
  Если проверка прошла успешно, то производим запуск двигателей(вызываем
 метод запуска двигателя). После этого производиться обратный отсчет (10 ..... 1).
 После обратного отсчета вызываем метод старт переданного объекта.
 */

import modules.six.cosmodrome.shuttles.IStart;

public class Cosmodrome {

    public void launch(IStart shuttle) {
        if (!shuttle.checkSystems()) {
            System.out.println("Предстартовая проверка провалена");
            return;
        }
        shuttle.startEngine();
        for(int i = 10; i > 0; i--)
            System.out.println(i);
        shuttle.launch();
    }
}
