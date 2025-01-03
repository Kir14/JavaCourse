package modules.six.robot.src.by.teachmeskills.robot;

import modules.six.robot.src.by.teachmeskills.robot.hands.IHand;
import modules.six.robot.src.by.teachmeskills.robot.heads.IHead;
import modules.six.robot.src.by.teachmeskills.robot.legs.ILeg;

public class Robot implements IRobot, Comparable<Robot> {
    private IHead head;
    private IHand hand;
    private ILeg leg;

    public Robot(IHead head, IHand hand, ILeg leg) {
        this.head = head;
        this.hand = hand;
        this.leg = leg;
    }

    public Robot() {
    }

    public IHead getHead() {
        return head;
    }

    public void setHead(IHead head) {
        this.head = head;
    }

    public IHand getHand() {
        return hand;
    }

    public void setHand(IHand hand) {
        this.hand = hand;
    }

    public ILeg getLeg() {
        return leg;
    }

    public void setLeg(ILeg leg) {
        this.leg = leg;
    }

    @Override
    public void action() {
        head.speak();
        hand.upHand();
        leg.step();
    }

    /**
     * Get the cost of a robot
     *
     * @return int
     */
    @Override
    public int getPrice() {
        int price = head.getPrice() + hand.getPrice() + leg.getPrice();
        return price;
    }

    @Override
    public int compareTo(Robot r) {
        if (getPrice() == r.getPrice()) {
            return 0;
        } else if (getPrice() > r.getPrice()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Робот стоимостью " + getPrice()
                + "\n    " + head
                + "\n    " + hand
                + "\n    " + leg;
    }

}
