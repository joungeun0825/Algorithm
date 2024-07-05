import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        StringBuilder sb = new StringBuilder("");

        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            char a = s.charAt(i);
            boolean flag = false;
            for (int j=0; j<i; j++) {
                if(a==s.charAt(j)){
                    flag = true;
                    cnt += 1;
                    break;
                }
            }
            if(!flag){
                sb.append(a);
            }
        }
        
        sb.append(cnt+4);
        sb.insert(0,1906+N);
        sb.reverse().toString();
        sb.insert(0,"smupc_");
        System.out.print(sb);
    }
}
