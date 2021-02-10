public class Homework3 {
    public static void main(String[] args) {
        System.out.println("Задание 3");
        float answer = equation(17,14.57f,18,6);
        String space = " ";
        System.out.println("Вычисляющий и возвращающий результат метод" + space + answer);
    }

       public static float equation(float a, float b, float c, float d){
        return  a * (b + (c / d));
        }
    }
