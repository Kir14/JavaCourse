package modules.three.homework.cat.src;

public class Cat {
    private static final int COUNT_EYES = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    private static int count;

    static {
        count = 0;
    }

    private double originWeight;
    private double weight;

    //private double minWeight;
    //private double maxWeight;

    private CatColors color;
    private double foodEaten;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        color = CatColors.values()[(int) (Math.random() * 3)];
        count++;
    }

    public Cat(double weight) {
        this.weight = weight;
        originWeight = weight;
        color = CatColors.values()[(int) (Math.random() * 3)];
        count++;
    }

    public Cat(Cat cat) {
        this.weight=cat.weight;
        this.color = cat.color;
        this.originWeight=weight;
        count++;
    }

    public Cat(int weight, CatColors color){
        this.weight = weight;
        this.color = color;
        this.originWeight = weight;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public CatColors getColor() {
        return color;
    }

    public void setColor(CatColors color) {
        this.color = color;
    }

    private void checkDead() {
        String status = getStatus();
        if ("Dead".equals(status) || "Exploded".equals(status)) {
            count--;
        }
    }

    public boolean isAlive() {
        return !(weight < MIN_WEIGHT) && !(weight > MAX_WEIGHT);
    }

    public void meow() {
        if (isAlive()) {
            weight = weight - 1;
            System.out.println("Meow");
            checkDead();
        }

    }

    public double getFoodEaten() {
        return foodEaten;
    }

    public void feed(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            foodEaten += amount;
            checkDead();
        }
    }

    public void pee() {
        if (isAlive()) {
            weight -= 20;
            System.out.println("Pee");
            checkDead();
        }
    }

    public void drink(Double amount) {
        if (isAlive()) {
            weight = weight + amount;
            checkDead();
        }
    }

    public Double getWeight() {
        return weight;
    }

    public String getStatus() {
        if (weight < MIN_WEIGHT) {
            return "Dead";
        } else if (weight > MAX_WEIGHT) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}