import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long M = sc.nextLong();

        long P = 0;
        for (int i=0; i<N; i++) {
            P += sc.nextLong();
        }
        
        for (int i=0; i<M; i++) {
            long b = sc.nextLong();
            if(b!=0){
                P*=b;
            }
        }
        
        System.out.println(P);
    }
}
