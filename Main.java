//Задание 1
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"one", "two", "three", "four", "five", "one", "seven", "eight", "one", "four"};
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");


        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");
    }
}

