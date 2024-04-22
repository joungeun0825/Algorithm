import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,d,k,c,start,total,max;
    static int[] arr, visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new int[d+1];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        visited[c]=1;
        max = 1;
        total = max;
        slide();
        System.out.println(max);
    }
    
    public static void slide(){
        
        for (int i=0; i<k; i++) {
            if(visited[arr[i]]==0){
                total++;
            }
            visited[arr[i]] += 1;
        }
        start = 0;
        max = total;
        for (int i=k; i<N; i++) {
            
            visited[arr[start]] -= 1;
            if(visited[arr[start]]==0){
                total-=1;
            }
            
            if(visited[arr[i]]==0){
                total+=1;
            }
            visited[arr[i]] += 1;
            
            max = Math.max(max,total);
            
            start++;
            
        }
    }
}
