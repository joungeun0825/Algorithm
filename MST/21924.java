import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static boolean[] visited;
    static List<Node>[] tree;
    static long leastValue, total;
    static class Node implements Comparable<Node>{
        int to;
        int price;

        public Node(int to, int price){
            this.price = price;
            this.to = to;
        }

        @Override
        public int compareTo(Node node){
            return this.price - node.price;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        tree = new ArrayList[B+1];
        visited = new boolean[B+1];

        for (int i=1; i<=B; i++) {
            tree[i] = new ArrayList<>();
        }

        total = 0;
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b,c));
            tree[b].add(new Node(a,c));
            total += c;
        }

        leastValue = 0;
        connect(1);
        
        for (int i=1; i<=B; i++) {
            if(!visited[i]){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(total-leastValue);
    }
    
    public static void connect(int start){
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(start,0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            int weight = now.price;
            int node = now.to;
            
            if(!visited[node]){
                visited[node] = true;
                leastValue += weight;
            }

            for (Node next : tree[node]) {
                if(!visited[next.to]){
                    q.add(next);
                }
            }
        }
        
    }
}
