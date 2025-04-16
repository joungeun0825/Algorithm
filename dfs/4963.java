import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int a;
    static int b;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        while(a != 0 && b != 0) {
            arr = new int[b][a];
            for(int i=0; i<b; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<a; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(search());
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
        }
    }

    private static int search() {
        int sum = 0;
        for(int i=0; i<b; i++) {
            for(int j=0; j<a; j++) {
                if(arr[i][j] == 1) {
                    sum++;
                    travel(i, j);
                }
            }
        }
        return sum;
    }

    private static void travel(int i, int j) {
        arr[i][j] = 0;
        for(int x=0; x<8; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];
            if(nx >= 0 && nx < b && ny >= 0 && ny < a && arr[nx][ny] == 1) {
                travel(nx, ny);
            }
        }
    }
}
