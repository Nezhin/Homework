public class Human implements Actions {
    private String name;
    private int runDistance;
    private int jumpHigh;


    public Human(String name, int runDistance, int jumpHigh) {
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHigh = jumpHigh;
    }

    public void run(Treadmill t) {
        if (runDistance >= t.getLength()) {
            System.out.println("Human " + name + " has ran succsessful " + t.getLength() + " km");
        } else {
            System.out.println("The distance " + t.getLength() + " km is too long for human " + name);
        }
    }

public void jump(Wall w){
        if(jumpHigh>= w.getHeight()){
            System.out.println("Human "+ name+" has done succsessful "+w.getHeight()+" m high");
        }else{
            System.out.println("The wall "+w.getHeight()+" m is too high for human "+name);
        }
}
}