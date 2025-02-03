import java.io.*;
import java.util.*;

public class Main {
    static int[][] baseNum = {
        {1, 1, 1, 0, 1, 1, 1},  // 0
        {0, 0, 1, 0, 0, 1, 0},  // 1
        {1, 0, 1, 1, 1, 0, 1},  // 2
        {1, 0, 1, 1, 0, 1, 1},  // 3
        {0, 1, 1, 1, 0, 1, 0},  // 4
        {1, 1, 0, 1, 0, 1, 1},  // 5
        {1, 1, 0, 1, 1, 1, 1},  // 6
        {1, 1, 1, 0, 0, 1, 0},  // 7
        {1, 1, 1, 1, 1, 1, 1},  // 8
        {1, 1, 1, 1, 0, 1, 1}   // 9
    };
    static int[][] oldNum;
    static int[][] newNum;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t =0; t<T;t++){
            oldNum = makeNum(sc.next());
            newNum = makeNum(sc.next());
            int cnt = 0;
            for(int j = 0; j < 5; j++){
                for(int c = 0; c < 7; c++){
                    if(oldNum[j][c] != newNum[j][c]){
                        // System.out.println("j ="+j+", c = "+c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static int[][] makeNum(String s){
        int[][] tempNum = new int[5][7];
        int[] nums = s.chars().map(c -> c-'0').toArray();
        for(int i = nums.length - 1; i >= 0; i--){
             tempNum[4 - (nums.length - 1 - i)]= baseNum[nums[i]];
        }
        return tempNum;
    }
}
