import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,L,R;
    static int[][] arr;
    static ArrayList<int[]> list;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(move());
        
    }

    public static int move(){
        int answer = 0;
        while(true){
            visited = new boolean[N][N];
            boolean isMove = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        int result = bfs(i,j);
                        if(list.size()>1){
                            changePopulation(result);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove)
				return answer;
			answer++;
        }
    }

    public static void changePopulation(int result){
        int avg = result / list.size();
        for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			arr[x][y] = avg;
		}
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();
        
        list.add(new int[] {x,y});
        q.add(new int[] {x,y});
        visited[x][y] = true;
        int sum = arr[x][y];
        
        while(!q.isEmpty()){
            int now[] = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(!visited[nx][ny]){
                        int gap = Math.abs(arr[now[0]][now[1]]-arr[nx][ny]);
                        if(L <= gap && gap <= R){
                            visited[nx][ny] = true;
                            list.add(new int[] {nx,ny});
                            q.add(new int[] {nx,ny});
                            sum += arr[nx][ny];
                        }
                    }
                }
            }
        }
        
        return sum;
        
    }
}
