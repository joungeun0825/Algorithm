import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character,int[]> map = new HashMap<Character,int[]>();
        map.put('q', new int[]{0,0});
        map.put('w', new int[]{0,1});
        map.put('e', new int[]{0,2});
        map.put('r', new int[]{0,3});
        map.put('t', new int[]{0,4});
        map.put('y', new int[]{0,5});
        map.put('u', new int[]{0,6});
        map.put('i', new int[]{0,7});
        map.put('o', new int[]{0,8});
        map.put('p', new int[]{0,9});
        map.put('a', new int[]{1,0});
        map.put('s', new int[]{1,1});
        map.put('d', new int[]{1,2});
        map.put('f', new int[]{1,3});
        map.put('g', new int[]{1,4});
        map.put('h', new int[]{1,5});
        map.put('j', new int[]{1,6});
        map.put('k', new int[]{1,7});
        map.put('l', new int[]{1,8});
        map.put('z', new int[]{2,0});
        map.put('x', new int[]{2,1});
        map.put('c', new int[]{2,2});
        map.put('v', new int[]{2,3});
        map.put('b', new int[]{2,4});
        map.put('n', new int[]{2,5});
        map.put('m', new int[]{2,6});
        
        char left = sc.next().charAt(0);
        char right = sc.next().charAt(0);
        
        String consonants = "qwertasdfgzxcv";
        String vowels = "yuiophjklbnm";
        
        String s = sc.next();
        int cnt = s.length();
        for(int i=0;i<s.length();i++){
            char now = s.charAt(i);

            if (consonants.indexOf(now) != -1) {
                int nl = Math.abs(map.get(left)[0] - map.get(now)[0]) + Math.abs(map.get(left)[1] - map.get(now)[1]);
                left = now;
                cnt += nl;
            }else{
                int nr = Math.abs(map.get(right)[0] - map.get(now)[0]) + Math.abs(map.get(right)[1] - map.get(now)[1]);
                right = now;
                cnt += nr;
            }
        }
        System.out.println(cnt);

        
    }
}
