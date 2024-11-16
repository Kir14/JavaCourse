package moduleThree.HomeWork.builder.src;

public class Builder {

    private String name;
    private Appartment appartment;


    public class Appartment {

        private int number;
        private boolean windowOpen;
        private boolean doorOpen;
        private boolean lightOn;

        {
            windowOpen = false;
            doorOpen = false;
            lightOn = false;
        }

        public Appartment() {
            number = 0;
        }

        public Appartment(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public boolean isWindowOpen() {
            return windowOpen;
        }

        public boolean isDoorOpen() {
            return doorOpen;
        }

        public boolean isLightOn() {
            return lightOn;
        }

        @Override
        public String toString() {
            return "\nКвартира № " + number + "\nДверь " + (doorOpen ? "открыта" : "закрыта") +
                    "\nОкно " + (windowOpen ? "открыто" : "закрыто") +
                    "\nСвет " + (lightOn ? "включен" : "выключен");
        }
    }

    public void openWindow() {
        appartment.windowOpen = true;
    }

    public void closeWindow() {
        appartment.windowOpen = false;
    }

    public void turnOnLight() {
        appartment.lightOn = true;
    }

    public void turnOffLight() {
        appartment.lightOn = false;
    }

    public void openDoor() {
        appartment.doorOpen = true;
    }

    public void closeDoor() {
        appartment.doorOpen = false;
    }

    public Builder(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAppartment(Appartment appartment) {
        this.appartment = appartment;
    }

    public Appartment getAppartment() {
        return appartment;
    }

    public Appartment buildApartment(int number) {
        appartment = new Appartment(number);
        System.out.println("Хорошая работа " + name);
        return appartment;
    }
}
