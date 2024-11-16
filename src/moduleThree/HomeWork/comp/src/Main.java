package moduleThree.HomeWork.comp.src;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer("intel", 12, "Huge", 2);
        System.out.println(computer);
        int n = computer.getTimeToDie() - 1;
        for (int i = 0; (i < n) && (computer.getTimeToDie() != 0); i++) {
            computer.turnOn();
            computer.turnOff();
        }
        if (computer.getTimeToDie() != 0) {
            System.out.println("Alive Ahahahah");
            computer.turnOn();
        }
    }
}
