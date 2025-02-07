import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        int[] dp = new int[11]; // n은 최대 10까지

        // 초기 조건 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // DP 테이블 채우기
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        // 테스트 케이스 실행
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }
    }
}
