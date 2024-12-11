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

        Store store = new Store();

        store.addProducts(TypeCategory.FRUIT, apple);
        store.addProducts(TypeCategory.FRUIT, grape, pear, goldApple);
        store.addProducts(TypeCategory.TECH, toaster, blender, fridge, kettle);

        User oleg = new User("oleg", "111");
        User kir = new User("kir", "111");

        store.users.add(oleg);
        store.users.add(kir);

        System.out.println("--------Print Store----------");
        System.out.println(store);

        System.out.println("--------Print Fruits----------");
        System.out.println(store.getCategoryProductsString(TypeCategory.FRUIT));

        System.out.println("--------Print Users----------");
        System.out.println(store.getUsersString());

        oleg.buyProduct(apple);
        oleg.buyProduct(pear);
        oleg.buyProduct(fridge);

        kir.buyProduct(grape);
        kir.buyProduct(goldApple);
        kir.buyProduct(toaster);
        kir.buyProduct(kettle);
        kir.declineProduct(toaster);

        System.out.println("--------Print Store----------");
        System.out.println(store);
    }
}
