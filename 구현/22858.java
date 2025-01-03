import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] s = new int[n + 1];
        int[] d = new int[n + 1];
        int[] p = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            s[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            d[i] = sc.nextInt();
        }

        for (int i = 0; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                p[d[j]] = s[j];
            }
            for (int j = 1; j <= n; j++) {
                s[j] = p[j];
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(p[i]+" ");
        }

    }
}
