import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean v[];
    public static int[] arr;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		int M = in.nextInt();
        
        arr = new int[M];
        v = new boolean[N];
        dfs(N,M,0);
    }
    public static void dfs(int N, int M, int depth){

        if(depth==M){
            for (int a : arr) {
                System.out.print(a+" ");    
            }
            System.out.println();
            return;
        }
        
        for (int i=0;i<N;i++) {
            
            if(!v[i]){
                v[i] = true;
                arr[depth]=i+1;
                dfs(N,M,depth+1);
                v[i] = false;
            }
            
        }
        
        
    }
}
