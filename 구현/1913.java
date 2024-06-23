import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int val, num, x_val, y_val;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        num = sc.nextInt();
        arr = new int[N][N];

        val = (int) Math.pow(N, 2);
        x_val = -1;
        y_val = -1;

        for (int i = 0; i < N / 2; i++) {
            int j = N - 1 - i;
            down(i, j - 1, i);
            right(i, j - 1, j);
            up(j, i + 1, j);
            left(j, i + 1, i);
        }

        arr[N / 2][N / 2] = val;
        if(val==num){
            x_val=N/2;
            y_val=N/2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.newLine();
        }

        bw.write((x_val + 1) + " " + (y_val + 1));
        bw.newLine();

        bw.flush();
        bw.close();
    }

    public static void down(int start, int end, int x) {
        for (int i = start; i <= end; i++) {
            if (val == num) {
                x_val = i;
                y_val = x;
            }
            arr[i][x] = val;
            val--;
        }
    }

    public static void right(int start, int end, int x) {
        for (int i = start; i <= end; i++) {
            if (val == num) {
                x_val = x;
                y_val = i;
            }
            arr[x][i] = val;
            val--;
        }
    }

    public static void up(int start, int end, int x) {
        for (int i = start; i >= end; i--) {
            if (val == num) {
                x_val = i;
                y_val = x;
            }
            arr[i][x] = val;
            val--;
        }
    }

    public static void left(int start, int end, int x) {
        for (int i = start; i >= end; i--) {
            if (val == num) {
                x_val = x;
                y_val = i;
            }
            arr[x][i] = val;
            val--;
        }
    }
}
