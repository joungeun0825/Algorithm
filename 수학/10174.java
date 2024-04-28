import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            List<Character> list = new ArrayList<>();
            String str = br.readLine();
            str = str.toLowerCase();
            StringBuffer sb = new StringBuffer(str);
            String reversedStr = sb.reverse().toString();
            solve(str, reversedStr);
        }
    }

    public static void solve(String str, String reversedStr){
        
        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) != reversedStr.charAt(i)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

}
