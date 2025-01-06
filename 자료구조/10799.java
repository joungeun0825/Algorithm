import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("");

        int stick = 0;
        String before = "(";
        Deque<String> queue = new LinkedList<>();
        for (String a : arr) {
            if (a.equals("(")) {
                queue.push(a);
                stick++;
            } else {
                queue.poll();
                if (before.equals("(")) {
                    stick--;
                    stick += queue.size();
                }
            }
            before = a;
        }

        System.out.println(stick);

    }
}
