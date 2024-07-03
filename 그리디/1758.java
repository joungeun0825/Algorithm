import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        ArrayList<Long> list = new ArrayList<>();
        for (int i=0; i<T; i++) {
            list.add(sc.nextLong());
        }

        Collections.sort(list, Comparator.reverseOrder());
        int idx = 1;
        Long total = 0L;
        for (Long l : list) {
            Long tip = l-(idx-1);
            if(tip>=0){
                total += tip;
            }
            idx++;
        }
        System.out.println(total);
    }
}
