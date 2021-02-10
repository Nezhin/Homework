public class Homework8 {
    public static void main(String[] args) {
        int year = calculate(2000);
    }
        public static int calculate(int x){
    if(x % 4 == 0 || x % 400 == 0 || x % 100 != 0) {
            System.out.println("Год" + x + "является високосным");
        }else{
            System.out.println("Год" + x + "не является високосным");
        }
    return x;
    }
}
