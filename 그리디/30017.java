import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int patty = sc.nextInt();
        int cheese = sc.nextInt();

        while (patty>=0) {
            if(patty-1<=cheese){
                System.out.println(patty+patty-1);
                return;
            }else{
                patty -= 1;
            }
        }
    }
}
