import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] bus = new int[5000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long cnt = 0;
        
        for(int i=0; i<n; i++){
            bus[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            int more = 0;
            for(int k=i+1; k<n; k++){
                if(bus[i] < bus[k]) more++;
                else cnt += more;
            }
        }

        System.out.println(cnt);
    }
}
