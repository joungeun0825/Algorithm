import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static long[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int N;
    static int M;
    static long min;
    // tip: arguments are passed via the field below this editor
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new long[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Long.parseLong(st.nextToken());
            }   
        }

        search();

        st = new StringTokenizer(br.readLine());
        if(map[N-1][M-1]>Integer.parseInt(st.nextToken())){
            System.out.println("NO");
        }else{
            System.out.println("YES");
            System.out.println(map[N-1][M-1]);
        }
        
    }

    public static void search(){

        for (int i=1; i<M; i++) {
            map[0][i] += map[0][i-1];
        }

        for (int i=1; i<N; i++) {
            map[i][0] += map[i-1][0];
        }

        for (int i=1; i<N; i++) {
            for (int j=1; j<M; j++) {
                min = Math.min(map[i][j-1],map[i-1][j]);
                map[i][j] += min;
            }
        }
    }
}
