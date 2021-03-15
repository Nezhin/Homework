public class Main {
    public static void main(String[] args) {

        Human[] h = new Human[3];
        h[0] = new Human("Bob", 8, 4);
        h[1] = new Human("Victor", 11, 3);
        h[2] = new Human("Boris", 5, 2);
        Cat[] c = new Cat[3];
        c[0] = new Cat("Bazya", 3, 3);
        c[1] = new Cat("Murzik", 1, 4);
        c[2] = new Cat("Philip", 5, 2);
        Robot[] r = new Robot[3];
        r[0] = new Robot("T265", 100, 10);
        r[1] = new Robot("G18", 50, 7);
        r[2] = new Robot("Ar63", 200, 20);
        Treadmill[] t = new Treadmill[2];
        t[0] = new Treadmill(2);
        t[1] = new Treadmill(10);
        Wall[] w = new Wall[3];
        w[0] = new Wall(1);
        w[1] = new Wall(2);
        w[2] = new Wall(4);
        for (Human a : h) {
         for(Treadmill b:t){
             a.run(b);
         }
        for(Wall d:w){
            a.jump(d);
        }
        }
        for(Cat e:c){
            for(Treadmill b:t){
                e.run(b);
            }
            for(Wall d:w){
                e.jump(d);
            }
        }
        for(Robot f:r){
            for(Treadmill b:t){
                f.run(b);
            }
            for(Wall d:w){
                f.jump(d);
            }
        }


            }

        }








