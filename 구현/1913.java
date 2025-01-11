import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int n = sc.nextInt();
        int x = sc.nextInt();

        int[][] arr = new int[n][n];
        int currentX = 0, currentY = 0;
        int resultX = 0, resultY = 0;
        int number = n * n;
        int direction = 0;
        while (number > 0) {
            arr[currentX][currentY] = number;
            if (number == x) {
                resultX = currentX;
                resultY = currentY;
            }
            number--;

            int nextX = currentX + dx[direction];
            int nextY = currentY + dy[direction];

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || arr[nextX][nextY] != 0) {
                direction = (direction + 1) % 4; // 방향 변경
                nextX = currentX + dx[direction];
                nextY = currentY + dy[direction];
            }
            currentX = nextX;
            currentY = nextY;
        }

        for (int[] a : arr) {
            for (int now : a) {
                System.out.print(now + " ");
            }
            System.out.println();
        }

        System.out.println((resultX + 1) + " " + (resultY + 1));


    }
}
