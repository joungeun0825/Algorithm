import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String record : records) {
            String[] ra = record.split(" ");
            String[] tm = ra[0].split(":");
            int minute = Integer.parseInt(tm[0]) * 60 + Integer.parseInt(tm[1]);

            int key = Integer.parseInt(ra[1]);
            if (ra[2].equals("IN")) {
                map.put(key, map.getOrDefault(key, 0) - minute);
            } else {
                map.put(key, map.get(key) + minute);
            }
        }

        // 23:59에 출차되지 않은 차량 처리
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() <= 0) {
                map.put(entry.getKey(), entry.getValue() + 23 * 60 + 59);
            }
        }

        // 차량 번호순으로 정렬
        List<Integer> carNumbers = new ArrayList<>(map.keySet());
        Collections.sort(carNumbers);

        // 요금 계산
        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            int time = map.get(carNumbers.get(i));
            if (time <= fees[0]) {
                answer[i] = fees[1];
            } else {
                answer[i] = fees[1] + (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            }
        }

        return answer;
    }
}
