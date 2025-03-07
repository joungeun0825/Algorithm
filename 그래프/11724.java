import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node> nodes = new ArrayList<>();

    static class Node {
        int value;
        List<Integer> connected;
        boolean visited;

        public Node(int value) {
            this.value = value;
            connected = new ArrayList<>();
            visited = false;
        }

        public void connect(int to) {
            this.connected.add(to);
        }

        public void find() {
            this.visited = true;
            for (int i : connected) {
                if(!nodes.get(i).visited){
                    nodes.get(i).find();
                }
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int vCnt = Integer.parseInt(st.nextToken());

        nodes.add(new Node(0));
        for (int i = 1; i <= nodeCnt; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 1; i <= vCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            nodes.get(from).connect(to);
            nodes.get(to).connect(from);
        }

        int cnt = 0;
        for (int i = 1; i <= nodeCnt; i++) {
            if (!nodes.get(i).visited) {
                cnt++;
                nodes.get(i).find();
            }
        }

        System.out.println(cnt);
    }
}
