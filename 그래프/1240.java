import java.util.*;
import java.io.*;
import java.lang.*;

class Main{
    static class Node{
        int num;
        int weight;

        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    static List<Node>[] node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            node[i] = new ArrayList<>();
        }
        
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            node[a].add(new Node(b,c));
            node[b].add(new Node(a,c));
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            solve(x,y);
            Arrays.fill(visited,false);
        }
        
    }
    public static void solve(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(!visited[now.num]){
                visited[now.num] = true;
                if(now.num == y){
                    System.out.println(now.weight);
                }
                for (Node n : node[now.num]) {
                    if(!visited[n.num]){
                        q.add(new Node(n.num,now.weight+n.weight));
                    }
                }
            }
            
        }
        
    }
}
