import java.io.*;
import java.util.*;

public class Main {
    static int[][] pixels;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int H;
    static int W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        pixels = new int[H][W];
        for(int i=0; i<H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++){
                pixels[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int changeColor = Integer.parseInt(st.nextToken());
            int originalColor = pixels[x][y];
            if (originalColor != changeColor) {
                changePixels(x, y, originalColor, changeColor);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                sb.append(pixels[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void changePixels(int x, int y, int originalColor, int changeColor){
        pixels[x][y] = changeColor;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx&&nx<H&&0<=ny&&ny<W&&pixels[nx][ny]==originalColor){
                changePixels(nx, ny, originalColor, changeColor);
            }
        }
    }
}
