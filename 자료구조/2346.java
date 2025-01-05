import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] val = new int[n][2];

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            val[i][0] = i+1;
            val[i][1] = sc.nextInt();
            queue.add(val[i]);
        }

        List<Integer> result = new ArrayList<>();
        int[] now = queue.poll();
        result.add(now[0]);

        while (!queue.isEmpty()) {
            if(now[1] > 0) {
                for(int i =0;i<now[1]-1;i++){
                    queue.add(queue.poll());
                }
                now = queue.poll();
                result.add(now[0]);
            }else{
                for(int i =0;i<Math.abs(now[1])-1;i++){
                    queue.addFirst(queue.pollLast());
                }
                now = queue.pollLast();
                result.add(now[0]);
            }
        }

        for(int r : result) {
            System.out.print(r+" ");
        }
    }
}
