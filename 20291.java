import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        TreeMap<String, Integer> map = new TreeMap<>();
        
        for (int i=0; i<N; i++) {
            String input = sc.next();
            int idx = input.indexOf(".");
            String extention = input.substring(idx+1);

            if(map.containsKey(extention)){
                map.put(extention, map.get(extention)+1);
            }else{
                map.put(extention, 1);
            }
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
