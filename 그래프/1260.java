import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Node[] node;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        node = new Node[N];

        for(int x=0;x<N;x++){
            node[x] = new Node();
            node[x].setVisited();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            
            node[first-1].addLink(second-1);
            node[second-1].addLink(first-1);
        }

        for(int j=0;j<N;j++){
            node[j].listUp();
        }

        node[V-1].visited = true;
        dfs(V-1);
        for(int x=0;x<N;x++){
            node[x].setVisited();
        }
        System.out.println();
        bfs(V-1);
        
    }
    public static void dfs(int idx){
        System.out.print((idx+1)+" ");
        for (int n : node[idx].getValue()) {
            if(!node[n].visited){
                node[n].visited = true;
                dfs(n);
            }
        }
    }
    public static void bfs(int idx){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
		node[idx].visited = true;
        while (!queue.isEmpty()) {
			int v = queue.remove();
            System.out.print((v+1)+" ");
			for (int n : node[v].getValue()){
                if (!node[n].visited ) {
					node[n].visited  = true;
					queue.add(n);
                    
				}
        
            }
				
		}
    }
}

class Node{
    ArrayList<Integer> list;
    boolean visited;

    public Node(){
        this.list = new ArrayList<Integer>();
    }

    public void addLink(int link){
        this.list.add(link);
    }

    public List<Integer> getValue() {
        return list;
    }
    public void listUp(){
        Collections.sort(this.list);
    }
    public void setVisited(){
        this.visited = false;
    }
}
