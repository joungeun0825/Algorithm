import java.util.*;
import java.lang.*;
import java.io.*;



class Main {
    static char[][] map;
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int building = 0;
    static int destroy = 0;
    static Queue<Building> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        arr = new int[n][m];
        queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == '@') {
                    queue.offer(new Building(i, j));
                }

                if (map[i][j] == '*') {
                    building++;
                } else if (map[i][j] == '#') {
                    arr[i][j] = 2;
                    building++;
                }
            }
        }
        bfs();

        building -= destroy;
        sb.append(destroy).append(' ').append(building);
        System.out.println(sb);
    }

    public static void bfs() {
        Building building = queue.poll();

        for (int i = 0; i < 4; i++) {
            int nx = building.x + dx[i];
            int ny = building.y + dy[i];
            for (int j = 0; j < 2; j++) {

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '|') {
                    continue;
                }

                if (map[nx][ny] == '*') {
                    queue.offer(new Building(nx, ny));
                    map[nx][ny] = '.';
                    destroy++;
                }

                if (map[nx][ny] == '#') {
                    arr[nx][ny] -= 1;
                }
                nx += dx[i];
                ny += dy[i];
            }
        }

        while (!queue.isEmpty()) {
            Building b = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = b.x + dx[i];
                int ny = b.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == '|') {
                    continue;
                }

                if (map[nx][ny] == '*') {
                    queue.offer(new Building(nx, ny));
                    map[nx][ny] = '.';
                    destroy++;
                }

                if (map[nx][ny] == '#') {
                    arr[nx][ny] -= 1;
                }

                if (map[nx][ny] == '#' && arr[nx][ny] == 0) {
                    queue.offer(new Building(nx, ny));
                    destroy++;
                }
            }
        }
    }

    public static class Building {
        int x;
        int y;

        Building(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
