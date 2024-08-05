import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageCount = new int[N+2];
        HashMap<Integer, Double> failureRate = new HashMap<>();
        int users = stages.length;
        
        // 스테이지에 머물러 있는 사용자 수 카운트
        for (int stage : stages) {
            stageCount[stage]++;
        }
        
        // 스테이지별 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (users > 0) {
                failureRate.put(i, (double) stageCount[i] / users);
                users -= stageCount[i];
            } else {
                failureRate.put(i, 0.0);
            }
        }
        
        // 실패율을 값 기준으로 내림차순 정렬
        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(failureRate.entrySet());
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        
        // 정렬된 키를 배열로 변환
        for (int i = 0; i < entryList.size(); i++) {
            answer[i] = entryList.get(i).getKey();
        }
        
        return answer;
    }
}
