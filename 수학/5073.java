import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> list = new ArrayList<>();
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            int[] arr = {a, b, c};
            Arrays.sort(arr);
            a = arr[0];
            b = arr[1];
            c = arr[2];
            if (c >= a + b) {
                System.out.println("Invalid");
            } else {
                if (a == b && b == c) {
                    System.out.println("Equilateral");
                } else if (a != b && b != c && a != c) {
                    System.out.println("Scalene");
                } else {
                    System.out.println("Isosceles");
                }
            }
        }
    }
}
