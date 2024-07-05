import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int a[] = new int[N];
        for (int i=0; i<N; i++) {
            a[i] = sc.nextInt();
        }

        int b[] = new int[N];
        for (int i=0; i<N; i++) {
            b[i] = a[i] - sc.nextInt();
        }

        int result = 0;
        for (int i=0; i<N; i++) {
            if(b[i]>0){
                result += b[i];
            }
        }

        System.out.println(result);

        
    }
}
