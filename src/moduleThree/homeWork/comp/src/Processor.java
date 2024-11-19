package moduleThree.homeWork.comp.src;

public class Processor {

    private String company;
    private double frequency;

    public Processor(String company, double frequency) {
        this.company = company;
        this.frequency = frequency;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "Proc " + company + " " + frequency + " Gh";
    }
}
