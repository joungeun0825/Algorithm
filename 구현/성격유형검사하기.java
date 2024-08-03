import java.util.*;
import java.io.*;
import java.lang.*;
    
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        for (int i = 0; i < survey.length; i++) {
            char disagreeType = survey[i].charAt(0);
            char agreeType = survey[i].charAt(1);
            int choice = choices[i];
            
            // 선택지에 따라 점수 업데이트
            if (choice < 4) { // 비동의 선택지
                map.put(disagreeType, map.get(disagreeType) + (4 - choice));
            } else if (choice > 4) { // 동의 선택지
                map.put(agreeType, map.get(agreeType) + (choice - 4));
            }
        }
        
        if(map.get('R')>=map.get('T')){
            answer += 'R';
        }else{
            answer += 'T';
        }
        
        if(map.get('C')>=map.get('F')){
            answer += 'C';
        }else{
            answer += 'F';
        }
        
        if(map.get('J')>=map.get('M')){
            answer += 'J';
        }else{
            answer += 'M';
        }
        
        if(map.get('A')>=map.get('N')){
            answer += 'A';
        }else{
            answer += 'N';
        }
        return answer;
    }
}
