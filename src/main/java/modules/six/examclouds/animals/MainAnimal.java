package modules.six.examclouds.animals;

public class MainAnimal {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[3];

        zoo[0] = new Cat("Матроскин");
        zoo[1] = new Dog("Шарик");
        zoo[2] = new Bear("Потап");

        Doctor doc = new Doctor();

        for (Animal an : zoo) {
            doc.treatAnimal(an);
        }

        for (Animal an : zoo) {
            an.makeNoise();
            an.eat();
        }

    }
}
