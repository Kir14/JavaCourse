package modules.six.human;

/*
У человека поля:-имя-куртка-штаны-обувь
 У человека есть 2 метода:- одеться(вызываются методы надеть у всех вещей)- раздеться (вызываются методы снять у всех вещ
 */

import modules.six.human.jacket.IJacket;
import modules.six.human.pants.IPants;
import modules.six.human.shoes.IShoes;

public class Human {

    private String name;
    private IJacket jacket;
    private IPants pants;
    private IShoes shoes;

    public Human(String name, IJacket jacket, IPants pants, IShoes shoes) {
        this.name = name;
        this.jacket = jacket;
        this.pants = pants;
        this.shoes = shoes;
    }

    public void putOnAll() {
        jacket.putOn();
        pants.putOn();
        shoes.putOn();
    }

    public void takeOffAll() {
        jacket.takeOff();
        pants.takeOff();
        shoes.takeOff();
    }

    @Override
    public String toString() {
        return name + " имеется " + jacket + ", " + pants + ", " + shoes;
    }
}
