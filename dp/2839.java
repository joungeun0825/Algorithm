import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int three_idx = 0;
        
        while(N!=0){
            
            if(N<0){
                System.out.print(-1);
                return;
            }

            if(N % 5 == 0){
                N /= 5;
                System.out.print(N+three_idx);
                return;
            }

            three_idx++;
            
            N -= 3;
                
        }
        
        System.out.print(three_idx);
    }
}
