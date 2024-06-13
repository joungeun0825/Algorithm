import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M,T;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs(0,0);
        if(result<=T){
            System.out.println(result);
        }else{
            System.out.println("Fail");
        }
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y,0,-1});
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int now[] = q.poll();
            if(now[0] == N-1 && now[1] == M-1){
                min = Math.min(min,now[2]);
            }
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(now[3]==-1){
                        if(!visited[nx][ny][0]){
                            if(map[nx][ny]==0){
                                q.add(new int[] {nx, ny, now[2]+1, now[3]});
                                visited[nx][ny][0] = true;
                            }else if(map[nx][ny]==2){
                                q.add(new int[] {nx, ny, now[2]+1, 1});
                                visited[nx][ny][1] = true;
                            }
                        }
                    }
                    else{
                        if(!visited[nx][ny][1]){
                            q.add(new int[] {nx, ny, now[2]+1, now[3]});
                            visited[nx][ny][1] = true;

                            }
                        }
                    }
                }
            }
        return min;
    }
}
