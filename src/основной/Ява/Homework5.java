public class Homework5 {
    public static void main(String[] args) {
        int answer = lol(-6);
    }
    public static int lol(int a) {
        if (a >= 0) {
            System.out.println("Число" + a + "положительное");
        } else {
            System.out.println("Число" + a + "отрицательное");
        }
        return a;
    }
}
