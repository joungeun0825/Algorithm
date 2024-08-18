import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();

        if (cacheSize == 0) {
            return cities.length * 5;
        }

        for (String city : cities) {
            String cityUpper = city.toUpperCase();
            
            // 캐시에 있는지 확인
            if (cache.remove(cityUpper)) {
                answer += 1; // 캐시 히트
            } else {
                answer += 5; // 캐시 미스
                if (cache.size() >= cacheSize) {
                    cache.pollFirst(); // 가장 오래된 항목 제거
                }
            }
            cache.addLast(cityUpper); // 캐시에 최신 항목 추가
        }

        return answer;
    }
}
