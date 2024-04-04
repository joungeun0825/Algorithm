import java.io.*;
import java.util.*;

public class Main {
	static long total;
	static List<Node>[] list;
	static boolean[] visited;
	static class Node implements Comparable<Node>{
		int to;
		int value;
		
		public Node(int to, int value) {
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return this.value - o.value;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[v+1];
		visited = new boolean[v+1];
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=v; i++) {
            st = new StringTokenizer(br.readLine());
			for(int j=1; j<=v; j++) {
                int x = Integer.parseInt(st.nextToken());
                list[i].add(new Node(j,x));
    		}
		}
		
		prim(1);
		System.out.println(total);
	}
	
	static void prim(int start) {
		Queue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start,0));
		while(!pq.isEmpty()) {
			Node p = pq.poll();
			int node = p.to;
			int weight = p.value;
			
			if(visited[node]) continue;
			// 선택한 간선의 정점으로부터 가장 낮은 가중치 갖는 정점 선택 
			visited[node]= true;
			total += weight;
			
			for(Node next : list[node]) {
				if(!visited[next.to]) {
					pq.add(next);
				}
			}
		}
		
	}
}
