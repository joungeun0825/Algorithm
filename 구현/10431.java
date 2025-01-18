import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(sc.nextInt() + " ");
            int[] heights = new int[20];
            for (int j = 0; j < 20; j++) {
                heights[j] = sc.nextInt();
            }
            System.out.println(lineUp(heights));
        }
    }

    private static int lineUp(int[] heights) {
        List<Integer> lines = new ArrayList<>();
        int cnt = 0;
        for (int height : heights) {
            int position = 0;
            while (position < lines.size() && lines.get(position) < height) {
                position++;
            }
            cnt += lines.size() - position;
            lines.add(position, height);
        }
        return cnt;
    }
}
