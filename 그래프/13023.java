import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<Integer>[] arr;
    static boolean[] visited;
    static boolean result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N];
        visited = new boolean[N];
        result = false;
        for (int i=0; i<N; i++) {
            arr[i] = new ArrayList<>();
        }
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        for (int i=0; i<N; i++) {
            visited[i] = true;
            dfs(i,1);
            if(result){
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }
        System.out.println(0);
    }

    public static void dfs(int x, int depth){
        if(depth == 5){
            result=true;
            return;
        }
        
        for (int next : arr[x]) {
            if(!visited[next]){
                visited[next] = true;
                dfs(next, depth+1);
                visited[next] = false;
            }
        }
        
    }
}
