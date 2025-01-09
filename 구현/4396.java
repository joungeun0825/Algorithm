import java.util.*;

public class Main {
    private static final int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; // 8방향
    private static final int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        char[][] arr = new char[n][n];
        char[][] open = new char[n][n];
        char[][] result = new char[n][n];
        boolean gameOver = false;

        //초기화
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            open[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = open[i][j];
                if (c == 'x') {
                    if(arr[i][j] == '*'){
                        gameOver = true;
                    }
                    result[i][j] = String.valueOf(search(i, j, arr)).charAt(0);
                }else {
                    result[i][j] = '.';
                }
            }
        }

        if(gameOver) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j] == '*'){
                        System.out.print("*");
                    }else{
                        System.out.print(result[i][j]);
                    }
                }
                System.out.println();
            }
        }else{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(result[i][j]);
                }
                System.out.println();
            }
        }

    }

    private static int search(int i, int j, char[][] arr) {
        int cnt = 0;
        for (int x = 0; x < 8; x++) {
            int nx = i + dx[x];
            int ny = j + dy[x];
            if (0 <= nx && nx < n && 0 <= ny && ny < n && arr[nx][ny] == '*') {
                cnt += 1;
            }
        }
        return cnt;
    }
}
