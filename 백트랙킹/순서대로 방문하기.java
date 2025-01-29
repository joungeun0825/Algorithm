import java.io.*;
import java.util.*;

class Point{
    public int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(){}
    public boolean equals(Point other) {
        return this.x == other.x && this.y == other.y;
    }
}

public class Main {
    public static int n,m,cnt = 0;
    public static final int[] dx = {0,0,1,-1};
    public static final int[] dy = {1,-1,0,0};
    public static int[][] grid;
    public static boolean[][] visit;
    public static Point[] dest;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        visit  = new boolean[n][n];
        dest = new Point[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                grid[i][j] = sc.nextInt();
                visit[i][j] = false;
            }
        }
        
        for(int i=0; i<m; i++) {
            dest[i] = new Point(sc.nextInt()-1,sc.nextInt()-1);
        }

        dfs(dest[0], 0);
        System.out.print(cnt);
    }

    private static void dfs(Point now, int destIdx) {
        if(now.equals(dest[destIdx])) {
            if(destIdx == m-1) {
                cnt++;
                return;
            }
            destIdx++;
        }

        int x = now.x; int y = now.y;
        visit[x][y] = true;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny] && grid[nx][ny] == 0) {
                dfs(new Point(nx,ny),destIdx);
            }
        }
        visit[x][y] = false;
    }
}
