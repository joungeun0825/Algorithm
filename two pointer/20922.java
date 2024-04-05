import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] cnt = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int end = 1;
        int start = 1;
        int len = 0;
        int answer = 0;
        while (end<=N) {
            while (end<=N && cnt[arr[end]]<K) {
                cnt[arr[end]] += 1;
                end += 1;            
            }
            len = end - start;
            answer = Math.max(answer,len);
            cnt[arr[start]]--;
            start += 1;
            
        }
        System.out.println(answer);
        
    }
}
