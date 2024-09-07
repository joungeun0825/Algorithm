import java.util.*;
import java.util.Map.Entry;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> result = new ArrayList<>();
        for(int c : course){
            Map<String, Integer> map = new HashMap<>();
            for(String o : orders){
                char[] charArray = o.toCharArray();
                Arrays.sort(charArray);
                
                comb(charArray, new StringBuilder(), map, 0, c);                
            }
            
            int max = 2;
            for(int val : map.values()){
                max = Math.max(max,val);
            }

            for(Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == max){
                    result.add(entry.getKey());
                }
            }
            
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    public void comb(char[] charArray, StringBuilder str, Map<String, Integer> map, int start, int targetLength){
        if(str.length() == targetLength){
            map.put(str.toString(),map.getOrDefault(str.toString(),0)+1);
            return;
        }
        
        for(int i=start; i<charArray.length; i++){
            str.append(charArray[i]);
            comb(charArray, str, map, i+1, targetLength);
            str.deleteCharAt(str.length()-1);
        }
    }
}
