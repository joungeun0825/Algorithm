import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static String st;
    public static void search(){
        char[] duck = {'q','u','a','c','k'};
        ArrayList<Character> arr = new ArrayList<>();
        int idx = 0;
        int res = 0;
        
        for (int i=0; i<st.length(); i++) {
            arr.add(st.charAt(i));
        }

        while(true){
            
            for (int i=0; i<arr.size(); i++) {
                char next = arr.get(i);
                char wanna = duck[idx];

                if(next == wanna){
                    idx = (idx + 1) % 5;
                    arr.remove(i);
                    i--;
                }
            }

            if(idx==0){
                res++;
            }else{
                System.out.println(-1);
                return;
            }

            if(arr.isEmpty()){
                System.out.println(res);
				return;
            }
            
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine();

        if(st.charAt(0)!='q'||st.length() % 5 != 0){
            System.out.println(-1);
            return;
        }

        search();
    }
}
