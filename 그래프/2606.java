import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static ArrayList<Integer>[] node;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        node = new ArrayList[M+1];
        visited = new boolean[M+1];
        for(int i=1;i<=M;i++){
            node[i] = new ArrayList<Integer>();
        }
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            node[x].add(y);
            node[y].add(x);
        }

        cnt = 0;
        dfs(1);
        System.out.println(cnt-1);
            
    }

    public static void dfs(int start){
        visited[start] = true;
        cnt += 1;
        
        for (int x : node[start]) {
            if(!visited[x]){
                dfs(x);
            }
        }     
        
        
    }
}
