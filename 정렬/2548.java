import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int x = arr[i];
            for (int j = 0; j < n; j++) {
                sum += Math.abs(arr[j] - x);
            }
            pair[i][0] = arr[i];
            pair[i][1] = sum;
        }

        Arrays.sort(pair, (a, b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        System.out.println(pair[0][0]);
    }
}
