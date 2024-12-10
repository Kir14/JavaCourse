package modules.six.human;

/*
По аналогии с первым задание делаем след. задание.
 Интерфейсы:- Куртка- Штаны- Обувь
 в каждом интерфейсе есть 2 метода (надеть и снять)
 Делаем несколько реализации каждого интерфейса.
 Создаём класс человек:
 У человека поля:-имя-куртка-штаны-обувь
 У человека есть 2 метода:- одеться(вызываются методы надеть у всех вещей)- раздеться (вызываются методы снять у всех вещ
 */

import modules.six.human.jacket.LeatherJacket;
import modules.six.human.jacket.Windbreaker;
import modules.six.human.pants.Jeans;
import modules.six.human.pants.Trousers;
import modules.six.human.shoes.Shoes;
import modules.six.human.shoes.Sneakers;

public class MainHuman {
    public static void main(String[] args) {
        Human human1 = new Human("Oleg", new LeatherJacket("leather"), new Jeans(34), new Shoes(45));
        System.out.println(human1);
        human1.putOnAll();
        human1.takeOffAll();
        System.out.println();
        Human human2 = new Human("Oleg2", new Windbreaker("material"), new Trousers(32), new Sneakers(42));
        System.out.println(human2);
        human2.putOnAll();
        human2.takeOffAll();
    }
}
