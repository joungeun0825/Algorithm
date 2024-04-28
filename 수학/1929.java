import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();

        boolean[] isNotPrime = new boolean[to+1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        
        for(int i=2; i<=Math.sqrt(to); i++){
            if(!isNotPrime[i]){
                for(int j=i*i; j<=to; j=j+i){
                    isNotPrime[j] = true;
                }
            }
    
        }

        for(int j=from; j<=to; j++){
            if(!isNotPrime[j]){
                System.out.println(j);
            }
        }
    }

}
