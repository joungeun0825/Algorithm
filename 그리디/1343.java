import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int dotcnt = 0;
        int idx = 0;
        String s = "";
        while(idx<str.length()){
            if(str.charAt(idx)=='X'){
                int xcnt = 0;
                while(idx<str.length() && str.charAt(idx)=='X'){
                    xcnt+=1;
                    idx++;
                }
                s += change(xcnt);
            }else{
                s += ".";
                idx++;
            }
        }
        System.out.println(s);
    }
    
    public static String change(int n){
        
        String tmp = "";
        for (int i=0; i<n/4; i++) {
            tmp += "AAAA";
        }
        
        if((n%4)%2!=0){
            System.out.println(-1);
            System.exit(0);
        }
        
        n = (n%4)/2;
        for (int i=0; i<n; i++) {
            tmp += "BB";
        }
        return tmp;
    }
}
