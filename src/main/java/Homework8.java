public class Homework8 {
    public static void main(String[] args) {
        int x = 2000;  //x=год
        if(x % 4 == 0 || x % 400 == 0 || x % 100 != 0) {
            System.out.println("Год" + x + "является високосным");
        }else{
            System.out.println("Год" + x + "не является високосным");

        }
    }
}
