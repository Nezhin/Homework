public class Robot implements Actions {
    private String id;
    private int runDistance;
    private int jumpHigh;

    public Robot(String id, int runDistance, int jumpHigh) {
        this.id = id;
        this.runDistance = runDistance;
        this.jumpHigh = jumpHigh;
    }

    public void run(Treadmill t) {
        if (runDistance >= t.getLength()) {
            System.out.println("Robot " + id + " has ran succsessful "+t.getLength()+" km");
        } else {
            System.out.println("The distance "+t.getLength()+" km is too long for robot " + id);
        }
    }

    public void jump(Wall w) {
        if (jumpHigh >= w.getHeight()) {
            System.out.println("Robot " + id + " has done succsessful "+w.getHeight()+" m");
        } else {
            System.out.println("The wall "+w.getHeight()+" m is too high for robot " + id);
        }

    }
}
