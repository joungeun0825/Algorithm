import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = N-1;

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        int ans = Integer.MAX_VALUE;
        int first=0;
        int second=0;
        while(start!=end){
            int result = arr[start] + arr[end];
            
            if(ans>Math.abs(result)){
                
                ans = Math.abs(result);
                first = arr[start];
                second = arr[end];
            }
            
            if(result<0){
                start++;
            }else{
                end--;
            }
        }
        
        System.out.println(first+" "+second);
        
    }
}
