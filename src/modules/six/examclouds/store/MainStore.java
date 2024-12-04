package modules.six.examclouds.store;

public class MainStore {
    public static void main(String[] args) {
        Product apple = new Product("Apple", 3.5, 4.2);
        Product grape = new Product("Grape", 6.3, 4.5);
        Product pear = new Product("Pear", 3.7, 3.8);
        Product goldApple = new Product("Golden Apple", 7.2, 4.9);

        Product toaster = new Product("Toaster", 123.5, 4.1);
        Product blender = new Product("Blender", 95.9, 4.2);
        Product fridge = new Product("Fridge", 456.2, 4.4);
        Product kettle = new Product("Kettle", 89.9, 4.8);

        Category fruits = new Category("Fruits");
        fruits.addProduct(apple);
        fruits.addProduct(grape);
        fruits.addProduct(pear);
        fruits.addProduct(goldApple);
        Category technic = new Category("Technic");
        technic.addProduct(toaster);
        technic.addProduct(blender);
        technic.addProduct(fridge);
        technic.addProduct(kettle);

        System.out.println("----------Categories-----------");
        System.out.println(fruits);
        System.out.println(technic);

        System.out.println();
        User oleg = new User("oleg", "111");
        oleg.buyProduct(apple);
        oleg.buyProduct(pear);
        oleg.buyProduct(fridge);
        System.out.println(oleg);

        System.out.println();
        User kir = new User("kir", "111");
        kir.buyProduct(grape);
        kir.buyProduct(goldApple);
        kir.buyProduct(toaster);
        kir.buyProduct(kettle);
        kir.declineProduct(toaster);
        System.out.println(kir);
    }
}
