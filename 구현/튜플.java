import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> list = new ArrayList<>();
        
        // 문자열 파싱
        for (int i = 1; i < s.length() - 1; ) {
            if (s.charAt(i) == '{') {
                i++;
                List<Integer> l = new ArrayList<>();
                String num = "";
                while (true) {
                    if (s.charAt(i) == ',') {
                        l.add(Integer.parseInt(num));
                        num = "";
                        i++;
                    } else if (s.charAt(i) == '}') {
                        l.add(Integer.parseInt(num));
                        list.add(l);
                        i++;
                        break;
                    } else {
                        num += s.charAt(i);
                        i++;
                    }
                }
            } else {
                i++;
            }
        }
        
        // 리스트 크기 기준 정렬
        list.sort(Comparator.comparingInt(List::size));
        
        // 중복 없는 숫자 찾기
        int[] answer = new int[list.size()];
        Set<Integer> used = new HashSet<>();
        
        for (int i = 0; i < list.size(); i++) {
            for (Integer val : list.get(i)) {
                if (!used.contains(val)) {
                    answer[i] = val;
                    used.add(val);
                    break;
                }
            }
        }
        
        return answer;
    }
}
