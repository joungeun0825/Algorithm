import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[1000001];
        dp[1]=0;
        dp[2]=1;
        dp[3]=1;

        for (int i=4; i<=n; i++) {
            int cnt = dp[i-1]+1;
            if(i%3==0){
                cnt = Math.min(cnt,dp[i/3]+1);
            }
            if(i%2==0){
                cnt = Math.min(cnt,dp[i/2]+1);
            }
            dp[i] = cnt;
        }   
        System.out.println(dp[n]);
    }
    
}
