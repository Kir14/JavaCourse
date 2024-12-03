package modules.six.examclouds.university;

public class Aspirant extends Student {

    private String nameScienceWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String nameScienceWork) {
        super(firstName, lastName, group, averageMark);
        this.nameScienceWork = nameScienceWork;
    }

    public String getNameScienceWork() {
        return nameScienceWork;
    }

    public void setNameScienceWork(String nameScienceWork) {
        this.nameScienceWork = nameScienceWork;
    }

    /*
    Переопределить этот метод в классе Aspirant.  Если средняя оценка аспиранта равна 5, то сумма 2500 грн, иначе 2200.
     */
    @Override
    public double getScholarship() {
        return getAverageMark() == 5 ? 2500 : 2200;
    }

    @Override
    public String toString() {
        return super.toString() + " науч работа " + nameScienceWork;
    }
}
