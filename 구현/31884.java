import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        HashMap<Integer, Integer> heights = new HashMap<>();
        int maxHeight;
        while(N-->0){
            int order = sc.nextInt();
            int x = sc.nextInt();
            
            switch (order) {
                case 1:
                    maxHeight = 0;
                    for (int j = x; j < x + 4; j++) {
                        maxHeight = Math.max(maxHeight, heights.getOrDefault(j, 0));
                    }
                    for (int j = x; j < x + 4; j++) {
                        heights.put(j, maxHeight + 1);
                    }
                    break;
                case 2:
                    heights.put(x, heights.getOrDefault(x, 0) + 4);
                    break;
                case 3:
                    System.out.println(heights.getOrDefault(x, 0));
                    break;
                    
            }
        }
    }
}
