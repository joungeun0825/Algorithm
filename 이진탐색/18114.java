import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물건의 개수
        int C = Integer.parseInt(st.nextToken()); // 목표 무게
        int[] w = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            // 1개 선택만으로 C에 도달 가능
            if (w[i] == C) {
                System.out.println(1);
                return;
            }
        }

        // 정렬
        Arrays.sort(w);

        // 2개 또는 3개 조합 탐색
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int sum = w[i] + w[j];
                if (sum > C) break; // 조합 합이 C를 초과하면 중단
                if (sum == C) {
                    System.out.println(1);
                    return;
                }
                // 3번째 값이 필요할 때
                int remaining = C - sum;
                if (binarySearch(w, j + 1, N - 1, remaining)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    // 이분 탐색 메서드
    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}
