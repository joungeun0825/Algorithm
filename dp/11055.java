import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int dp[] = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = arr[i];
            for(int j=0; j<i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(arr[i]+dp[j], dp[i]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }

}
