package modules.six.examclouds.animals;

public class Doctor {
    public void treatAnimal(Animal animal) {
        System.out.println("На приеме:");
        System.out.println("Кличка: " + animal.getName());
        System.out.println("Описание: " + animal.getDescription());
        System.out.println();
    }
}
