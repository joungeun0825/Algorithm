import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] dp = new int[101][101];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(fac(N).divide(fac(M)).divide(fac(N-M)));

        }
    
    public static BigInteger fac(int n){
        // 이미 탐색했던 경우 바로 반환
    	if(n<=1) {
    		return new BigInteger("1");
    	}
        return new BigInteger(String.valueOf(n)).multiply(fac(n-1));
    }
    
       
        
        
    
}
