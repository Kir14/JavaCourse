package modules.six.examclouds.phone;

public class Phone {
    private String number;
    private double weight;
    private String model;

    public Phone() {
        number = "";
        weight = 0.0;
        model = "";
    }

    public Phone(String number, String model) {
        this.model = model;
        this.number = number;
    }

    public Phone(String number, double weight, String model) {
        this(number, model);
        this.weight = weight;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String number) {
        System.out.println("Звонит " + name + " номер " + number);
    }

    public void sendMessage(String... numbers) {
        System.out.println("Отправка сообщений на номера");
        for (String number : numbers) {
            System.out.println(number);
        }
    }

    @Override
    public String toString() {
        return model + ", Номер " + number + ", вес " + weight + " кг";
    }
}

