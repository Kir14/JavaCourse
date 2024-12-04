package modules.six.examclouds.store;

import java.util.ArrayList;

public class Category {
    private String nameCategory;
    private ArrayList<Product> products;

    public Category(String nameCategory) {
        this.nameCategory = nameCategory;
        products = new ArrayList<>();
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

    public void setAllProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public boolean addProduct(Product p) {
        return products.add(p);
    }

    public Product getProduct(int i) {
        return products.get(i);
    }

    public Product removeProduct(int i) {
        return products.remove(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nameCategory).append(":\n");
        for (Product p : products) {
            sb.append(p).append("\n");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
