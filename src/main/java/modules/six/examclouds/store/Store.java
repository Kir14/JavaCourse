package modules.six.examclouds.store;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {

    ArrayList<User> users;
    private HashMap<TypeCategory, ArrayList<Product>> store;

    public Store() {
        users = new ArrayList<>();
        store = new HashMap<>();
    }

    public void addProducts(TypeCategory category, Product... products) {
        if (!store.containsKey(category)) {
            store.put(category, new ArrayList<>());
        }
        for (Product p : products) {
            store.get(category).add(p);
        }
    }

    public String getUsersString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Users:\n");
        for (User user : users) {
            sb.append(user).append("\n");
        }
        return sb.toString();
    }

    public HashMap<TypeCategory, ArrayList<Product>> getAllProducts() {
        return store;
    }

    public String getCategoryProductsString(TypeCategory category) {
        if (!store.containsKey(category)) {
            return "Not have any products";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(category).append(":\n");
        for (Product p : store.get(category)) {
            sb.append("  ").append(p).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TypeCategory category : store.keySet()) {
            sb.append(getCategoryProductsString(category));
        }
        sb.append(getUsersString());
        return sb.toString();
    }

}
