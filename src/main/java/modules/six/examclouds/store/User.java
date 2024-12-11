package modules.six.examclouds.store;


public class User {

    private String login;
    private String password;
    private Basket basket;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        basket = new Basket();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public boolean buyProduct(Product p) {
        return basket.products.add(p);
    }

    public void declineProduct(Product p) {
        basket.products.remove(p);
    }

    @Override
    public String toString() {
        return login + "\n" + basket;
    }

}
