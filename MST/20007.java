import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[] visited;
    static List<Node>[] list;
    static int cnt, X, N, total, day;
    static int[] dp;
    static class Node implements Comparable<Node>{

        int connect;
        int value;
        
        Node(int connect, int value){
            this.connect = connect;
            this.value = value;
        }

        @Override
        public int compareTo(Node node){
            return this.value - node.value;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        visited = new boolean[N];
        dp = new int[N];

        for (int i=0; i<N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        cnt = 0;
        dijkstra(Y);
        
        Arrays.sort(dp);

        total = 0;
        day = 1;
        visit();
        System.out.println(day);
        
        
    }
    public static void visit(){
        for (int i=0; i<N; i++) {

            if(dp[i]*2>X){
                day = -1;
				break;
            }
            
            total += dp[i]*2;

            if(total>X){
                day += 1;
                total = dp[i]*2;
            }
        }
        
    }

    public static void dijkstra(int start){
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start]=0;

        while(!q.isEmpty()){
            
            Node now = q.poll();
            int node = now.connect;
            int weight = now.value;

            if(!visited[node]){
                visited[node] = true;
            }
            
            for (Node next : list[node]) {
                if(!visited[next.connect]&&dp[next.connect]>weight+next.value){
                    dp[next.connect] = weight+next.value;
                    q.add(new Node(next.connect,dp[next.connect]));
                }
            }

        }
    }
}
