import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int sum = 0;
        int end = 0;
        int max = -1;
        int cnt = 1;
        while(start+X<=N){
            while (end<start+X) {
                sum += arr[end];
                end += 1;
            }
            if(sum>max){
                max = sum;
                cnt = 0;
            }
            if(sum == max){
                cnt += 1;
            }
            sum -= arr[start];
            start += 1;
        }

        if(max==0){
            System.out.println("SAD");
        }else{
            System.out.println(max);
            System.out.println(cnt);
        }
        
        
        
    }
}
