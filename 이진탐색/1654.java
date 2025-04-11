import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(); 
        int N = sc.nextInt();

        int[] arr = new int[K];
        long right = 0; // ✅ 최대 길이를 저장해야 하므로 0으로 시작
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]); // ✅ 가장 긴 랜선을 right로 설정
        }

        long left = 1;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += arr[i] / mid;
            }

            if (sum >= N) { // ✅ 조건 만족
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}
