package modules.eight.exception.consolecustomer.src;

import java.util.HashMap;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IllegalArgumentException {
        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Неверное количество аргументов");
        }
        if (!components[2].matches("^[A-Za-z](\\.?\\w)*@[A-Za-z]+\\.[A-Za-z]+$")) {
            throw new IllegalArgumentException("Неверный формат ввода почты");
        }
        if (!components[3].matches("^\\+\\d+")) {
            throw new IllegalArgumentException("Неверный формат ввода номера телефона");
        }
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws IllegalArgumentException {
        if (!storage.containsKey(name)) {
            throw new IllegalArgumentException("Такого покупателя нет");
        }
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}