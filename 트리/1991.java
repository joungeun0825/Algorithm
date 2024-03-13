import java.util.*;

class Main {
    static HashMap<String, List<String>> tree = new HashMap<>();
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(); // 노드 개수 입력

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            String n1 = sc.next();
            String n2 = sc.next();
            String n3 = sc.next();
            tree.put(n1, Arrays.asList(n2, n3));
        }

        boolean[] visited = new boolean[n]; // Initialize the visited array

        pre_dfs("A", visited);
        System.out.println();
        Arrays.fill(visited, false); // Reset visited array

        in_dfs("A", visited);
        System.out.println();
        Arrays.fill(visited, false); // Reset visited array

        post_dfs("A", visited);
    }

    static void pre_dfs(String node, boolean[] visited) {
        if (!node.equals(".") && !visited[node.charAt(0) - 'A']) {
            visited[node.charAt(0) - 'A'] = true;
            System.out.print(node);
            pre_dfs(tree.get(node).get(0), visited);
            pre_dfs(tree.get(node).get(1), visited);
        }
    }

    static void in_dfs(String node, boolean[] visited) {
        if (!node.equals(".") && !visited[node.charAt(0) - 'A']) {
            visited[node.charAt(0) - 'A'] = true;
            in_dfs(tree.get(node).get(0), visited);
            System.out.print(node);
            in_dfs(tree.get(node).get(1), visited);
        }
    }

    static void post_dfs(String node, boolean[] visited) {
        if (!node.equals(".") && !visited[node.charAt(0) - 'A']) {
            visited[node.charAt(0) - 'A'] = true;
            post_dfs(tree.get(node).get(0), visited);
            post_dfs(tree.get(node).get(1), visited);
            System.out.print(node);
        }
    }
}
