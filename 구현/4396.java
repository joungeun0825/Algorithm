import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map, answer;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {0, 1, -1, 1, -1, 0, 1, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        answer = new char[n][n];

        // 지뢰 위치 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
                answer[i][j] = '.'; // 초기화
            }
        }

        boolean gameOver = false;

        // 플레이어의 이동 입력
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'x') {
                    if (map[i][j] == '*') {
                        gameOver = true;
                    } else {
                        answer[i][j] = (char) (countAdjacentMines(i, j) + '0');
                    }
                }
            }
        }

        // 게임 오버 처리: 모든 지뢰를 표시
        if (gameOver) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '*') {
                        answer[i][j] = '*';
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }

    // 인접한 지뢰 개수 계산
    public static int countAdjacentMines(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == '*') {
                count++;
            }
        }
        return count;
    }
}
