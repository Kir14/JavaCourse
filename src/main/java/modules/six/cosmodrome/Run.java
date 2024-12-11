package modules.six.cosmodrome;

import modules.six.cosmodrome.shuttles.Shuttle;
import modules.six.cosmodrome.shuttles.SpaceX;

public class Run {
    public static void main(String[] args) {
        Cosmodrome cosmodrome = new Cosmodrome();

        Shuttle shuttle = new Shuttle();
        cosmodrome.launch(shuttle);

        SpaceX spaceX = new SpaceX();
        cosmodrome.launch(spaceX);
    }
}
