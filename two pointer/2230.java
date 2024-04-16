import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while(right < N){
            
            if(arr[right] - arr[left] < M){
                right++;
            } 
            else if(arr[right] - arr[left] == M){
                result = arr[right] - arr[left];
                break;
            }
            else{
                result = Math.min(result, arr[right] - arr[left]);
                left++;
            }
        }
        System.out.println(result);
    }
}
