package moduleThree.HomeWork.Cat.src;

public class Cat {
    private static int count;

    static {
        count = 0;
    }

    private double originWeight;
    private double weight;

    private double minWeight;
    private double maxWeight;

    private double foodEaten;

    public Cat() {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count++;

    }

    public static int getCount() {
        return count;
    }

    private void checkDead() {
        if (weight < minWeight) {
            count--;
        } else if (weight > maxWeight) {
            count--;
        }
    }

    public boolean isAlive() {
        if (weight < minWeight) {
            return false;
        } else if (weight > maxWeight) {
            return false;
        }
        return true;
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
        if (weight < minWeight) {
            return "Dead";
        } else if (weight > maxWeight) {
            return "Exploded";
        } else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }
}