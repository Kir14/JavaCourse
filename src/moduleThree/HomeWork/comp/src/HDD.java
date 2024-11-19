package moduleThree.HomeWork.comp.src;

public class HDD {
    private String company;
    private int memory;

    public HDD(String company, int memory) {
        this.memory = memory;
        this.company = company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getMemory() {
        return memory;
    }

    @Override
    public String toString() {
        return "HDD " + company + " " + memory + " GB";
    }
}
