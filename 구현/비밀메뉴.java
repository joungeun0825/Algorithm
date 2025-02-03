import java.io.*;
import java.util.*;

public class Main {
    static int[] secretKey;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();

        secretKey = new int[m];
        for(int i=0; i<m; i++){
            secretKey[i] = sc.nextInt();
        }

        int[] userKey = new int[n];
        for(int i=0; i<n; i++){
            userKey[i] = sc.nextInt();
        }

        if(n<m){
            System.out.println("normal");
            return;
        }

        for(int i=0; i<=n-m; i++){
            if(search(userKey, i)){
                System.out.println("secret");
                return;
            }
        }
        System.out.println("normal");
    }
    
    public static boolean search(int[] userKey, int i){
        for(int x=0; x<secretKey.length;x++){
            if(secretKey[x]!=userKey[(x+i)]){
                return false;
            }
        }
        return true;
    }
}
