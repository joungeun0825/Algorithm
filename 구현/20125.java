import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            grid[i] = sc.next().toCharArray(); // 입력을 바로 char 배열로 변환
        }

        int heartRow = 0, heartCol = 0;
        int leftArm = 0, rightArm = 0, waist = 0, leftLeg = 0, rightLeg = 0;

        // 1. 심장 위치 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == '*' && grid[i + 1][j] == '*') { // 심장은 허리가 연결된 첫 위치
                    heartRow = i + 1;
                    heartCol = j;
                    break;
                }
            }
            if (heartRow != 0) break; // 심장 위치를 찾았으면 탐색 종료
        }

        // 2. 팔 길이 계산
        for (int j = heartCol - 1; j >= 0; j--) {
            if (grid[heartRow][j] == '*') leftArm++;
            else break;
        }
        for (int j = heartCol + 1; j < N; j++) {
            if (grid[heartRow][j] == '*') rightArm++;
            else break;
        }

        // 3. 허리 길이 계산
        for (int i = heartRow + 1; i < N; i++) {
            if (grid[i][heartCol] == '*') waist++;
            else break;
        }

        // 4. 다리 길이 계산
        for (int i = heartRow + waist + 1; i < N; i++) {
            if (grid[i][heartCol - 1] == '*') leftLeg++;
            if (grid[i][heartCol + 1] == '*') rightLeg++;
        }

        // 5. 결과 출력
        System.out.println((heartRow + 1) + " " + (heartCol + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
