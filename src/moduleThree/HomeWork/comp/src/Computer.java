package moduleThree.HomeWork.comp.src;

public class Computer {

    private Processor processor;
    private RAM ram;
    private HDD hdd;
    private int timeToDie;
    private boolean isTurn;

    public Computer(Processor processor, RAM ram, HDD hdd, int timeToDie) {
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.timeToDie = timeToDie;
        this.isTurn = false;
    }

    public int getTimeToDie() {
        return timeToDie;
    }

    public boolean isTurn(){
        return isTurn;
    }

    public void turnOn() {
        if (isTurn) {
            System.out.println("Already On");
            return;
        }

        if (timeToDie == 0) {
            System.out.println("Already dead");
            return;
        }

        if (Math.round(Math.random()) == 0) {
            System.out.println("Dead");
            timeToDie = 0;
        } else {
            isTurn = true;
            timeToDie--;
        }
    }

    public void turnOff() {
        if ((timeToDie == 0) && !isTurn) {
            System.out.println("Already dead");
            return;
        }
        isTurn = false;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public String toString() {
        return ("Комп Песня \n" + processor + "\n" + ram
                + "\n" + hdd + "\n Включений до потухания " + timeToDie);
    }
}
