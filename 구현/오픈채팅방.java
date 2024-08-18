import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        ArrayList<String[]> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        for(String r:record){
            String[] ra = r.split(" ");
            if(ra[0].equals("Enter")){
                list.add(new String[]{ra[1],"님이 들어왔습니다."});
                map.put(ra[1], ra[2]);
            }else if(ra[0].equals("Leave")){
                list.add(new String[]{ra[1],"님이 나갔습니다."});
            }else if(ra[0].equals("Change")){
                map.put(ra[1], ra[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        int i = 0;
        for(String[] l:list){
            answer[i] = map.get(l[0])+l[1];
            i++;
        }
        return answer;
    }
}
