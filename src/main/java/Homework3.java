public class Homework3 {
    public static void main(String[] args) {
        System.out.println("Задание 3");
        float answer = equation();
        String space = " ";
        System.out.println("Вычисляющий и возвращающий результат метод" + space + answer);
    }

       public static float equation(){
          float  a = 17f, b = 14.57f, c = 18f, d = 6f;
          return  a * (b + (c / d));
        }
    }
