import java.util.*;

public class GraphCycleDetectionDFS {
    private int V;
    private List<List<Integer>> adj;

    public GraphCycleDetectionDFS(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u); // 무방향 그래프
    }

    private boolean dfs(int node, int parent, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited)) return true;
            } else if (neighbor != parent) {
                return true; // 부모가 아닌 방문한 노드를 다시 방문하면 사이클 발생
            }
        }
        return false;
    }

    public boolean hasCycle() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphCycleDetectionDFS graph = new GraphCycleDetectionDFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0); // 이 간선이 사이클을 만든다.

        System.out.println(graph.hasCycle() ? "사이클이 존재함" : "사이클이 없음");
    }
}
