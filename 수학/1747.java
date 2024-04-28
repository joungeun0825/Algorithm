import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    
    static boolean prime[] = new boolean[1004002];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        isPrime();

        for (int i=N; i<=1004000; i++) {
            if(!prime[i]){
                String str = String.valueOf(i);
                StringBuffer sb = new StringBuffer(str);
                String reversedStr = sb.reverse().toString();
                if(str.equals(reversedStr)){
                    System.out.println(i);
                    break;
                }
                
            }
        }
    }

    public static void isPrime() {
        prime[0] = true;
        prime[1] = true;
        for (int i=2; i<=Math.sqrt(1004000); i++) {
            if(!prime[i]){
                for (int j=i*i; j<=1004000; j+=i) {
                    prime[j] = true;
                }
            }
            
        }
    }

}
