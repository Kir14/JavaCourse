package modules.six.examclouds.university;

public class MainUniversity {
    public static void main(String[] args) {
        Student[] univ = new Student[5];

        univ[0] = new Student("Kir", "Kir", "23441", 5);
        univ[1] = new Student("Rik", "Rik");
        univ[2] = new Aspirant("oleg", "ovich", "213432", 5, "Tech");
        univ[3] = new Aspirant("Prosto", "chel", "212", 2, "READ");
        univ[4] = new Student("Stud", "ent", "11111", 3.4);

        for(Student st : univ) {
            System.out.print(st);
            System.out.println(" стипуха " + st.getScholarship());
        }
    }
}
