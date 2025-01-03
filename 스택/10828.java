import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            String s = br.readLine();

            if(s.startsWith("push")){
                int x = Integer.parseInt(s.split(" ")[1]);
                st.push(x);
            }else if(s.equals("top")){
                if(st.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(st.peek());
                }
            }else if(s.equals("empty")){
                if(st.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);   
                }
            }else if(s.equals("size")){
                System.out.println(st.size());
            }else if(s.equals("pop")){
                if(st.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(st.pop());
                }
            }
        }
    }
}
