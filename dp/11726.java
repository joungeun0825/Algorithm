import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] dp = new int[1001];
        dp[1]=1;
        dp[2]=2;
        
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }

        System.out.println(dp[N]);
        
    }
}
