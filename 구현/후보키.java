import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();
        
        // 모든 가능한 속성 조합을 비트마스크로 표현
        for (int i = 1; i < (1 << columnCount); i++) {
            if (isUnique(relation, i)) {
                // 최소성 검사: 후보키 리스트 중 현재 조합이 최소성을 만족하는지 확인
                boolean isMinimal = true;
                for (int key : candidateKeys) {
                    // (key & i) == key 인 경우 key가 i의 부분집합임을 의미
                    if ((key & i) == key) {
                        isMinimal = false;
                        break;
                    }
                }
                if (isMinimal) {
                    candidateKeys.add(i);
                }
            }
        }
        return candidateKeys.size();
    }

    // 유일성 검사 함수
    private boolean isUnique(String[][] relation, int subset) {
        Set<String> seen = new HashSet<>();
        
        for (String[] tuple : relation) {
            StringBuilder key = new StringBuilder();
            
            for (int i = 0; i < tuple.length; i++) {
                // 비트마스크를 이용해 subset에 포함된 속성들만 선택
                if ((subset & (1 << i)) != 0) {
                    key.append(tuple[i]).append(",");
                }
            }
            
            // 만들어진 키가 Set에 존재하면 유일하지 않음
            if (!seen.add(key.toString())) {
                return false;
            }
        }
        
        return true;
    }
}
