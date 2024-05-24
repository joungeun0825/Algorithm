import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList<>();
        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
        }
        
        for(int i=1;i<=N;i++){
            visited[i]=true;
            dfs(i,i);
            visited[i]=false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int l : list) {
            System.out.println(l);
        }
        
    }
    
    public static void dfs(int start, int target){
        
        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }
        if(target == arr[start]){
            list.add(target);
        }
    }
}
