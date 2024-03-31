import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            System.out.println(BC(M,N));
        }
        
    }
    public static int BC(int M, int N){

        if(dp[M][N]>0){
            return dp[M][N];
        }
        
        if( M==N || N==0 ){
            return dp[M][N] = 1;
        }
        
        return dp[M][N] = BC(M-1, N-1) + BC(M-1, N);
        
    }
}
