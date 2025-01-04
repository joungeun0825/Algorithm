import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String result = null;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                String part1 = s.substring(0, i);
                String part2 = s.substring(i, j);
                String part3 = s.substring(j);

                String reversed = new StringBuilder(part1).reverse().toString() +
                        new StringBuilder(part2).reverse().toString() +
                        new StringBuilder(part3).reverse().toString();

                if (result == null || reversed.compareTo(result) < 0) {
                    result = reversed;
                }
            }
        }

        System.out.println(result);
    }
}
