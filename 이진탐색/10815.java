import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[] card;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int find = Integer.parseInt(st.nextToken());
            sb.append(search(find)+" ");
            
        }
        System.out.println(sb);

    }

    static int search(int find){
        int first=0;
        int end = N-1;
        while (first<=end) {
            int mid = (first + end)/2;
            if(card[mid]==find){
                return 1;
            }else{
                if(card[mid]<find){
                    first = mid+1;
                }else{
                    end = mid-1;
                }
            }
            
        }
        return 0;
    }
}
