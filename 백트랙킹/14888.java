import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    static int min, max, N;
    static int[] num, op;
    static boolean[] v;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        
        v = new boolean[N];
        num = new int[N];
        for (int i=0; i<N; i++) {
            num[i] = sc.nextInt();
        }

        op = new int[4];
        for (int i=0; i<4; i++) {
            op[i] = sc.nextInt();
        }

        dfs(num[0],1);
        
        System.out.println(max);
        System.out.println(min);
        
    }

    public static void dfs(int sum, int idx){
        
        if(idx==N){
            min = Math.min(min,sum);
            max = Math.max(max,sum);
            return;
        }
        
        for(int f=0; f<4; f++){
            if(op[f] > 0){ // Checking if operation count is greater than 0
                op[f]--; // Decrementing the operation count
                dfs(calc(sum, num[idx], f), idx + 1);
                op[f]++; // Restoring the operation count
            }
        }
    }
    
    public static int calc(int x, int y, int oper){
        if(oper==0){
            return x + y;
        }
        else if(oper==1){
            return x - y;
        }
        else if(oper==2){
            return x * y;
        }
        else if(oper==3){
            return x / y;
        }
        return -1;
    }
}
