import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] m1 = {1,2,3,4,5};
        int[] m2 = {2,1,2,3,2,4,2,5};
        int[] m3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] hit = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(m1[i%m1.length] == answers[i]) hit[0]++;
            if(m2[i%m2.length] == answers[i]) hit[1]++;
            if(m3[i%m3.length] == answers[i]) hit[2]++;
        }
        
        int max = Math.max(hit[2], Math.max(hit[0], hit[1]));

        ArrayList<Integer> result = new ArrayList<>();
        if (hit[0] == max) result.add(1);
        if (hit[1] == max) result.add(2);
        if (hit[2] == max) result.add(3);
        
        // Convert ArrayList to array
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    
    }
}
