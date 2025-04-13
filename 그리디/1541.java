import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.indexOf("-") == -1) {
            System.out.println(calc(s));
            return;
        }

        String str[] = s.split("-");
        int result = calc(str[0]);
        for (int i = 1; i <str.length; i++) {
            result -= calc(str[i]);
        }
        System.out.println(result);
    }

    private static int calc(String expr) {
        if(expr.indexOf("+") == -1) {
            return Integer.parseInt(expr);
        }
        String str[] = expr.split("\\+");
        int sum = 0;
        for (int i = 0; i <str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }
}
