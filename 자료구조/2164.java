import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Scanner std = new Scanner(System.in);
        int N = std.nextInt();

        for(int i=1;i<=N;i++){
            q.offer(i);
        }
        
        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());

    }
}
