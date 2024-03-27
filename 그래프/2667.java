import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static ArrayList<Integer> result = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = s.charAt(j) - '0';
                visited[i][j] = false;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    int r = findHouse(i,j,N);
                    result.add(r);
                }
                
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (Integer r : result) {
            System.out.println(r+1);
        }
    }
    
        public static int findHouse(int x, int y, int N){
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		int r = 0;
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
		                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                		    continue;
        		        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
                    		continue;
                    
		                q.add(new int[] {nextX, nextY});
        		        map[nextX][nextY] = map[nowX][nowY] + 1;
                		visited[nextX][nextY] = true;
                        r += 1;
			}
		}
        return r;
	}
}
