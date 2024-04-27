import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static boolean[] v;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[M];
        v = new boolean[N];
        dfs(N,M,0,-1);
    }

    public static void dfs(int N, int M, int depth, int pre){

        if(depth==M){
            for (int a : arr) {
                System.out.print(a+" ");    
            }
            System.out.println();
            return;
        }

        for (int i=0;i<N;i++) {

            if(!v[i] && i>pre){
                v[i] = true;
                arr[depth]=i+1;
                dfs(N,M,depth+1,i);
                v[i] = false;
            }

        }


    }

}
