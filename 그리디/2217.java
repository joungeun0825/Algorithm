import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<T; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list,Comparator.reverseOrder());

        int idx = 1;
        int max = -1;
        for (Integer l : list) {
            max = Math.max(max, l*idx);
            idx++;
        }

        System.out.println(max);

        
    }
}
