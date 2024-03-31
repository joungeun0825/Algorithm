import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] dp = new int[11];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        int[] arr = new int[T];
        
        for (int i=0; i<T; i++) {
            int N = sc.nextInt();
            
            for (int j=4; j<=N; j++) {
                 dp[j] = dp[j-1] + dp[j-2] + dp[j-3];   
            }
            arr[i] = dp[N];
        }
        
        for (int i=0; i<T; i++) {
            System.out.println(arr[i]);
            
        }
        
    }
    
}
