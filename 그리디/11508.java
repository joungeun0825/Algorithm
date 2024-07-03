import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt();
        int[] prices = new int[N];
        
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }
        
        // 가격 내림차순 정렬
        Arrays.sort(prices);
        
        int totalCost = 0;
        for (int i = N - 1; i >= 0; i -= 3) {
            // 가장 비싼 2개만 비용에 추가
            totalCost += prices[i];
            if (i - 1 >= 0) totalCost += prices[i - 1];
            // 세 번째 아이템은 무료로 고려
        }
        
        System.out.println(totalCost);
        
        scanner.close();
    }
}
