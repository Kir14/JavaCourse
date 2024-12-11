package modules.six.cosmodrome.shuttles;

public class SpaceX implements IStart {

    @Override
    public boolean checkSystems() {
        return ((int) (Math.random() * 6) + 1) > ((int) (Math.random() * 6) + 1);
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели SpaceX запущены. Все системы в норме.");
    }

    @Override
    public void launch() {
        System.out.println("Старт SpaceX");
    }
}
