import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long budget;
    static int[] performance;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 컴퓨터 수
        budget = sc.nextLong();  // 예산
        performance = new int[n];

        // 성능 입력
        for (int i = 0; i < n; i++) {
            performance[i] = sc.nextInt();
        }

        // 이진 탐색을 위한 범위 설정
        long low = 1, high = 2*1000000000;  // 성능 범위는 1 ~ 1,000,000,000 (ai의 범위)

        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (test(mid)) {
                low = mid;  // 더 높은 성능을 목표로
            } else {
                high = mid - 1;  // 더 낮은 성능을 목표로
            }
        }
        System.out.println(low);
    }

    // 목표 성능으로 올리기 위한 비용 계산
    private static Boolean test(long target) {
        long cost = 0;
        for(int i = 0; i<n; i++) {
            if (performance[i] < target) {
                cost += (long)(target - performance[i]) * (target - performance[i]);
            }
            if(cost > budget) return false;
        }
        return true;
    }
}
