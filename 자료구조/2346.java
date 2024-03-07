import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());

        //deque 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deq = new ArrayDeque<>();
        for(int i=1;i<N+1;i++){
            deq.offerLast(new int[] { i, Integer.parseInt(st.nextToken()) });
        }

        //첫 풍선 터트려서 종이 안에 수 확인
         
        int[] pop = {0,0};
        pop = deq.pollFirst();
        int val = pop[1];
        sb.append(pop[0]).append(' ');
        while(!deq.isEmpty()){
            if(val>0){
                for(int x=1;x<val;x++){
                    deq.offerLast(deq.pollFirst());
                }
                pop = deq.pollFirst();
                val = pop[1];
                sb.append(pop[0]).append(' ');
            }
            else{
                for(int x=1;x<Math.abs(val);x++){
                    deq.offerFirst(deq.pollLast());
                }
                pop = deq.pollLast();
                val = pop[1];
                sb.append(pop[0]).append(' ');
            }
        }
    
        System.out.println(sb);
    }
}
