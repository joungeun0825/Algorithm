import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            stack.push(i);
        }
        
        int index = 0;
        sb.append("<");
        while(stack.size() > 1){
            index = (index + K-1)% stack.size();
            sb.append(stack.remove(index)).append(", ");
        }
        sb.append(stack.pop()).append(">");
        System.out.println(sb);
    }
}
