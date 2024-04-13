import java.io.*;
import java.util.*;
import java.lang.*;

class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static String flag;
    static int M,N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i=0; i<M; i++) {
            String s = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = s.charAt(j)-48;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            if(map[0][i]==0){
                list.add(i);
            }
        }

        flag = "NO";
        for (int l : list) {
            percolate(0,l);
        }
        System.out.println(flag);


        
    }
    
    public static void percolate(int x, int y){
        visited[x][y] = true;
        map[x][y] = 2;
        if(x==M-1){
            flag = "YES";
            return;
        }
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0<=nx && nx<M && 0<=ny && ny<N){
                if(!visited[nx][ny]&&map[nx][ny]==0){
                    percolate(nx,ny);
                }
            }
        }
        
    }
}
