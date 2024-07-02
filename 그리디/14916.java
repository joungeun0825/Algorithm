import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int coin = 0;
        while(n>0){
            if(n%5==0){
                coin += n/5;
                System.out.println(coin);
                return;
            }else{
                n -= 2;
                coin += 1;
            }
        }

        if(n<0){
            System.out.println(-1);
        }else{
            System.out.println(coin);
        }
        
    }
}
