package modules.six.examclouds.store;

public class Product {
    private String nameProduct;
    private double price;
    private double rate;

    public Product(String name, double price, double rate) {
        this.nameProduct = name;
        this.price = price;
        this.rate = rate;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String name) {
        this.nameProduct = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return nameProduct + ", цена: " + price + " BYN, рейтинг " + rate;
    }

}
