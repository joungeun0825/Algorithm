import java.util.*;
import java.lang.*;
class Solution {
    public ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        String tarr[] = today.split("\\.");
        long tdy = Long.parseLong(tarr[0])*28*12+Long.parseLong(tarr[1])*28+Long.parseLong(tarr[2]);
        for(String term : terms){
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));   
        }
        
        int idx = 1;
        for(String privacy : privacies){
            String parr[] = privacy.split(" ");
            int t = map.get(parr[1]);
            String darr[] = parr[0].split("\\.");
            long days = Long.parseLong(darr[0])*28*12+Long.parseLong(darr[1])*28+Long.parseLong(darr[2])+t*28;
            System.out.println(tdy+" "+(days-1));
            if(tdy>days-1){
                list.add(idx);
            }
            idx++;
        
        }
        
        Collections.sort(list);
        return list;
    }
}
