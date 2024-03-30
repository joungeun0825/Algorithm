import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] pay;
    static int[] arr;
    static boolean[] v;
    static int N, answer;
    static int before;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        pay = new int[N][N];
        arr = new int[N];
        v = new boolean[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                pay[i][j] = Integer.parseInt(st.nextToken());;
            }
        }
        before = -1;
        v[0] = true;
        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int next, int sum){
        boolean finish = true;
        for (int x=0; x<N ;x++ ) {
            if(!v[x]){
                finish = false;
            }
        }
        if(finish && pay[next][0] != 0){
            answer = Math.min(answer,sum+pay[next][0]);
            return;
        }
        
        for(int i=0;i<N;i++){
            if(!v[i] && pay[next][i]!=0){
                v[i] = true;
                dfs(i, sum+pay[next][i]);
                v[i] = false;
            }    
        }
        
    }
   
}
