import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] schedule = new int[n][2];
        for (int i = 0; i < n; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        Arrays.sort(schedule, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int prev_end = 0, cnt = 0;
        for (int i = prev_end; i < n; i++) {
            if (schedule[i][0] >= prev_end) {
                prev_end = schedule[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
