import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N+1];
        int dp[] = new int[N+1];
        for (int i=1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }
        dp[1]=arr[1];
        for (int i=2; i <= N; i++) {
            
            dp[i]=arr[i];

            if(dp[i]+dp[i-1]>dp[i]){
                dp[i]=dp[i]+dp[i-1];
            }
        }
        

        int max = Integer.MIN_VALUE;
        for (int i=1; i <= N; i++) {
            max=Math.max(max,dp[i]);
        }
        System.out.print(max);

    }
       
        
        
    
}
