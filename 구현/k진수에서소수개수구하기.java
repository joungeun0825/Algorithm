import java.util.*;

public class Solution {
    public int solution(int n, int k) {
        // Step 1: n을 k진수로 변환
        String kBase = Integer.toString(n, k);

        // Step 2: '0'을 기준으로 분할하여 소수 후보 찾기
        String[] candidates = kBase.split("0+");
        
        int count = 0;
        
        // Step 3: 각 후보가 소수인지 확인
        for (String candidate : candidates) {
            if (!candidate.isEmpty() && isPrime(Long.parseLong(candidate))) {
                count++;
            }
        }
        
        return count;
    }

    // 소수 판별 함수
    private boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // 테스트 케이스
        System.out.println(sol.solution(437674, 3)); // 결과: 3
        System.out.println(sol.solution(110011, 10)); // 결과: 2
    }
}
