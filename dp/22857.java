import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        for (int i=1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        
        for (int i=1; i<=N; i++) {
            int delCnt = K;
            if(arr[i]%2==0){
                dp[i] = 1;
            }
            else{
                delCnt-=1;
            }
            int j = i-1;
            while(delCnt>=0&&j>0){
                
                if(arr[j]%2==0){
                    dp[i]+=1;
                }
                else{
                    delCnt-=1;
                }
                j--;
            }
            
            
        }

        int max = -1;
        for (int d : dp) {
            
            max = Math.max(max,d);
        }
        System.out.println(max);
    }
}
