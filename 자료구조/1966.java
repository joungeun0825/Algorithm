

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        //테스트케이스 만큼 loop
        for(int i=0;i<T;i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            
            //N,M 초기화
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            //queue 연결리스트로 초기화
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int a=0;a<N;a++){
                queue.offer(new int[] { a, Integer.parseInt(st.nextToken()) });
            }

            int cnt=0;            
            while(!queue.isEmpty()){
                
                //가장 앞에 있는 거 하나 뽑기
                int[] now = queue.poll();
                boolean pop = true;

                //지금 중요도보다 더 큰 중요도가 있는 경우
                for(int[] q:queue){
                    if(q[1] > now[1]){
                        //뽑을 수 없음
                        pop = false;
                    }
                }
                //뽑아도 되는 경우
                if(pop){

                    //뽑음
                    cnt+=1;
                    //알아낼 문서가 맞다면
                    if(now[0] == M){
                        //cnt를 출력
                        sb.append(cnt).append('\n');
                        break;
                    }
                }
                //뽑으면 안되는 경우
                else{
                    //다시 큐에 집어넣음
                    queue.offer(now);
                }
            }
        }
        System.out.println(sb);
    }
}
