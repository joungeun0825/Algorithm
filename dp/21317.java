import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 돌 개수
        int[] small = new int[N]; // 작은 점프 비용
        int[] big = new int[N];   // 큰 점프 비용

        for (int i = 1; i < N; i++) {
            small[i] = sc.nextInt();
            big[i] = sc.nextInt();
        }

        int K = sc.nextInt(); // 매우 큰 점프 비용

        int INF = Integer.MAX_VALUE;
        int[] dp = new int[N + 1];      // 매우 큰 점프 없이 도착하는 최소 에너지
        int[] dpSuper = new int[N + 1]; // 매우 큰 점프 사용 후 최소 에너지
        Arrays.fill(dp, INF);
        Arrays.fill(dpSuper, INF);

        dp[1] = 0; // 1번 돌에서 시작

        // 기본 DP 점프 계산 (작은 점프, 큰 점프)
        for (int i = 1; i < N; i++) {
            if (i + 1 <= N) dp[i + 1] = Math.min(dp[i + 1], dp[i] + small[i]);
            if (i + 2 <= N) dp[i + 2] = Math.min(dp[i + 2], dp[i] + big[i]);
        }

        int answer = dp[N]; // 매우 큰 점프 없이 도착하는 경우의 최소값

        // 매우 큰 점프 고려
        for (int i = 1; i < N - 2; i++) { // i번째 돌에서 매우 큰 점프를 시도
            int superJumpEnergy = dp[i] + K;
            if (i + 3 <= N) {
                dpSuper[i + 3] = Math.min(dpSuper[i + 3], superJumpEnergy);
                // 이후부터는 작은 점프, 큰 점프 가능
                for (int j = i + 3; j < N; j++) {
                    if (j + 1 <= N) dpSuper[j + 1] = Math.min(dpSuper[j + 1], dpSuper[j] + small[j]);
                    if (j + 2 <= N) dpSuper[j + 2] = Math.min(dpSuper[j + 2], dpSuper[j] + big[j]);
                }
                answer = Math.min(answer, dpSuper[N]); // 최소 에너지 갱신
            }
        }

        System.out.println(answer);
    }
}
