package modules.six.examclouds.phone;

public class MainPhone {
    public static void main(String[] args) {
        Phone iphone = new Phone("+375441234567", 0.5, "16 Pro");
        Phone samsung = new Phone("+375297654321", 0.4, "J7");
        Phone nokia = new Phone("+375447777777", 1, "Stone");

        System.out.println(iphone);
        System.out.println(samsung);
        System.out.println(nokia);

        iphone.receiveCall("Kirill");

        samsung.sendMessage("374445215", "1111111", "3323231");
    }
}
