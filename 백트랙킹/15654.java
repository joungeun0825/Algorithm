import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static int[] dic;
    static boolean[] v;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        dic = new int[N];
        for(int i=0;i<N;i++){
            dic[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[M];
        Arrays.sort(dic);
        v = new boolean[N];
        dfs(N,M,0);
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth){

        if(depth==M){
            for (int a : arr) {
                sb.append(a+" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<N;i++){
            if(!v[i]){
                v[i]= true;
                arr[depth] = dic[i];
                dfs(N,M,depth+1);
                v[i]=false;
            }             
        }
    }
}
