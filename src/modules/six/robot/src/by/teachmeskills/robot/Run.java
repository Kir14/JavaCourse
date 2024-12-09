package modules.six.robot.src.by.teachmeskills.robot;

import modules.six.robot.src.by.teachmeskills.robot.hands.SamsungHand;
import modules.six.robot.src.by.teachmeskills.robot.hands.SonyHand;
import modules.six.robot.src.by.teachmeskills.robot.hands.ToshibaHand;
import modules.six.robot.src.by.teachmeskills.robot.heads.SamsungHead;
import modules.six.robot.src.by.teachmeskills.robot.heads.SonyHead;
import modules.six.robot.src.by.teachmeskills.robot.heads.ToshibaHead;
import modules.six.robot.src.by.teachmeskills.robot.legs.SamsungLeg;
import modules.six.robot.src.by.teachmeskills.robot.legs.SonyLeg;
import modules.six.robot.src.by.teachmeskills.robot.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */

        Robot robot1 = new Robot(new SonyHead(), new ToshibaHand(10), new SamsungLeg(15));
        Robot robot2 = new Robot(new SamsungHead(20), new SonyHand(12), new SonyLeg(17));
        Robot robot3 = new Robot(new ToshibaHead(), new SamsungHand(14), new ToshibaLeg());

        System.out.println("---robot 1-----");
        robot1.action();
        System.out.println("---robot 2-----");
        robot2.action();
        System.out.println("---robot 3-----");
        robot3.action();


    }
}
