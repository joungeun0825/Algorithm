import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        int start = 0;
        int end = N-1;

        while (start<end) {
            int sum = arr[start] + arr[end];
            if(sum == x){
                cnt+=1;
            }
            if(sum <= x){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(cnt);
    }
}
