import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int M, N;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int max;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];
        LinkedList<int[]> list = new LinkedList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(x==1){
                    list.add(new int[]{i,j});
                }
                box[i][j] = x;
            }
        }
        
        max = Integer.MIN_VALUE;
        bfs(list);

        boolean zero = false;
        for (int i=0; i<N; i++) {
            for(int j=0; j<M; j++){
                if(box[i][j]==0){
                    zero = true;
                }
            }
        }

        if(zero){
            System.out.println(-1);
        }else if(max == Integer.MIN_VALUE){
            System.out.println(0);
        }else{
           System.out.println(max-1); 
        }
    }

    public static void bfs(LinkedList<int[]> list){
        Queue<int[]> q = new LinkedList<>();

        for (int[] l : list) {
            q.add(l);
        }
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(box[nx][ny]==0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        box[nx][ny] = box[now[0]][now[1]]+1;
                        max = Math.max(box[nx][ny],max);
                        q.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
    }
}
