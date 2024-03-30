import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dic;
    static public int N,S;
    static public int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        dic = new int[N];
        for(int i=0;i<N;i++){
            dic[i]= Integer.parseInt(st.nextToken());
        }
        
        cnt = 0;
        dfs(0,0);
        
        if(S==0){
            cnt-=1;
        }
        System.out.println(cnt);
        
        
    }
    public static void dfs(int depth, int sum){
        if(depth == N) { // depth 가 마지막까지 갔을 경우
            if (sum == S) { // 그 중에 sum 이 타깃 넘버일 경우
                cnt++;
            }
            return;
        }
        dfs(depth + 1, sum + dic[depth]); // 원소를 선택했을 경우의 수열의 합
        dfs(depth + 1, sum);
    }
}
