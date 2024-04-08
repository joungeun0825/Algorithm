import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] tomato;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, col, max;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        tomato = new int[col][row];
        visited = new boolean[col][row];

        LinkedList<int[]> list = new LinkedList<>(); 
        
        for (int i=0; i<col; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<row; j++){
                int t = Integer.parseInt(st.nextToken());
                if(t == 1){
                    list.add(new int[]{i,j});
                }
                tomato[i][j] = t;
            }
        }

        max = Integer.MIN_VALUE;
        cntDays(list);

        boolean zero = false;
        for (int i=0; i<col; i++) {
            for(int j=0; j<row; j++){
                if(tomato[i][j]==0){
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

    public static void cntDays(LinkedList<int[]> list){
        Queue<int[]> q = new LinkedList<>();
        
        for (int[] l : list) {
            q.add(new int[]{l[0],l[1]});
        }
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(-1 < nx && nx < col && -1 < ny && ny < row){
                    if(visited[nx][ny]==false && tomato[nx][ny]==0){
                        visited[nx][ny] = true;
                        tomato[nx][ny] = tomato[now[0]][now[1]]+1;
                        if(max<tomato[nx][ny]){
                            max = tomato[nx][ny];
                        }
                        q.add(new int[]{nx, ny});
                    
                    } 
                }

            }
        }
        
    }

    
}
