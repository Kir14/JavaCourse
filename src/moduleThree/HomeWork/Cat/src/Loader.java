package moduleThree.HomeWork.Cat.src;

import java.util.Objects;

public class Loader
{
    public static void main(String[] args)
    {
        System.out.println(Cat.getCount());

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();

        System.out.println(cat1.getColor());
        System.out.println(cat3.getColor());

        System.out.println(Cat.getCount());

        System.out.println(cat1.getWeight());
        cat1.feed(10.0);
        System.out.println(cat1.getWeight());

        System.out.println(cat2.getWeight());
        cat2.feed(12.0);
        System.out.println(cat2.getWeight());

        cat3.feed(100000.0);
        System.out.println(cat3.getStatus());

        while (!Objects.equals(cat4.getStatus(), "Dead")) {
            cat4.meow();
        }
        System.out.println(cat4.getStatus());

        System.out.println(Cat.getCount());

        System.out.println(cat2.getWeight());
        cat2.pee();
        System.out.println(cat2.getWeight());

        System.out.println(cat3.getWeight());
        cat3.pee();
        System.out.println(cat3.getWeight());


    }
}