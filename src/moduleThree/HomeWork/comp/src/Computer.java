package moduleThree.HomeWork.comp.src;

public class Computer {

    private String processor;
    private int ram;
    private String hdd;
    private int timeToDie;
    private boolean isTurn;

    public Computer(String processor, int ram, String hdd, int timeToDie) {
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


    public String toString() {
        return ("Комп Песня \n Процессор: " + processor + "\n Оперативки гб: " + ram
                + "\n HHD от кампании " + hdd + "\n Включений до потухания " + timeToDie);
    }
}
