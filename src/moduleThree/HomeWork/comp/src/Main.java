package moduleThree.HomeWork.comp.src;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("intel", 12, "Huge", 4);
        System.out.println(computer);
        for (int i = 0; i < computer.getTimeToDie(); i++) {
            computer.turnOn();
            computer.turnOff();
        }
        if (computer.getTimeToDie() != 0) {
            System.out.println("Alive Ahahahah");
            computer.turnOn();
        }
    }
}
