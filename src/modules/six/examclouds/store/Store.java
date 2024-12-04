package modules.six.examclouds.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Store {

    HashMap<TypeCategory, ArrayList<Product>> store;

    public Store() {
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

    public HashMap<TypeCategory, ArrayList<Product>> getAllProducts() {
        return store;
    }

    public String getCategoryProducts(TypeCategory category) {
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
        for (Map.Entry<TypeCategory, ArrayList<Product>> entry : store.entrySet()) {
            sb.append(entry.getKey()).append(":\n");
            for (Product p : entry.getValue()) {
                sb.append("  ").append(p).append("\n");
            }
        }
        return sb.toString();
    }

}
