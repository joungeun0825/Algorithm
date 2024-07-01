import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {
            String original = br.readLine();
            StringBuilder sb = new StringBuilder(original);
            String reversed = sb.reverse().toString();

            String[] parts = reversed.split(" ");
            for (int j = parts.length-1; j >= 0; j--) {
                System.out.print(parts[j]+" ");
            }
            System.out.println();
        }
    }
}
