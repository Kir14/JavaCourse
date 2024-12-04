package modules.six.examclouds.store;

import java.util.ArrayList;

public class Basket {
    public ArrayList<Product> products;

    public Basket() {
        products = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Purchased products:\n");
        for (Product p : products) {
            sb.append(p).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
