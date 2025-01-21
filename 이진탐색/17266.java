import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 굴다리 길이
        int M = sc.nextInt(); // 가로등 개수
        int[] lamps = new int[M];
        
        for (int i = 0; i < M; i++) {
            lamps[i] = sc.nextInt();
        }
        
        int left = 1; // 최소 높이
        int right = N; // 최대 높이
        int result = N; // 최소 높이를 저장
        
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 높이
            if (isEnoughHeight(N, lamps, mid)) {
                result = mid; // 조건을 만족하면 결과 갱신
                right = mid - 1; // 더 낮은 높이를 탐색
            } else {
                left = mid + 1; // 더 높은 높이를 탐색
            }
        }
        
        System.out.println(result);
    }
    
    // 현재 높이로 모든 구간을 밝힐 수 있는지 확인하는 함수
    private static boolean isEnoughHeight(int N, int[] lamps, int height) {
        int covered = 0; // 현재 밝힌 마지막 위치
        
        for (int lamp : lamps) {
            if (covered < lamp - height) {
                // 어두운 구간 발생
                return false;
            }
            covered = lamp + height; // 새로운 밝힌 범위
        }
        
        // 마지막 구간까지 밝히는지 확인
        return covered >= N;
    }
}
