import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean students[] = new boolean[31];
        for(int i=1; i<=28; i++){
            students[sc.nextInt()] = true;
        }
        for(int i=1; i<=30; i++){
            if(!students[i]){
                System.out.println(i);
            }
        }
    }
}
