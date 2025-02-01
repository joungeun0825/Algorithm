import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static List<List<Point>> stackK; // 색깔별 점들을 저장하는 리스트
    static int minSize = Integer.MAX_VALUE; // 최소 면적

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 색깔별 점들을 저장할 리스트 초기화
        stackK = new ArrayList<>();
        for (int i = 0; i <= K; i++) {
            stackK.add(new ArrayList<>());
        }

        // 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            stackK.get(color).add(new Point(x, y));
        }

        // DFS 시작
        for (Point p : stackK.get(1)) {
            newDfs(2, p.x, p.x, p.y, p.y);
        }

        // 결과 출력
        System.out.println(minSize);
    }

    // DFS 함수
    static void newDfs(int S, int maxX, int minX, int maxY, int minY) {
        if (S == K + 1) {
            int nowSize = (maxX - minX) * (maxY - minY);
            if (nowSize < minSize) {
                minSize = nowSize;
            }
            return;
        }

        for (Point p : stackK.get(S)) {
            int newMaxX = Math.max(maxX, p.x);
            int newMinX = Math.min(minX, p.x);
            int newMaxY = Math.max(maxY, p.y);
            int newMinY = Math.min(minY, p.y);
            int newSize = (newMaxX - newMinX) * (newMaxY - newMinY);

            if (newSize < minSize) {
                newDfs(S + 1, newMaxX, newMinX, newMaxY, newMinY);
            }
        }
    }

    // 점을 표현하는 클래스
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
