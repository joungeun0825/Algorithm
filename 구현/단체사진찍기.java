import java.util.*;

public class Solution {
    // 8명의 캐릭터 정의
    private static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static int validCount;

    public static int solution(int n, String[] data) {
        validCount = 0;
        boolean[] visited = new boolean[8];
        char[] currentPermutation = new char[8];

        // 순열을 재귀적으로 생성하고 조건을 체크
        generatePermutations(visited, currentPermutation, 0, data);
        return validCount;
    }

    // 순열을 생성하는 메소드
    private static void generatePermutations(boolean[] visited, char[] currentPermutation, int depth, String[] data) {
        if (depth == 8) {
            if (isValid(currentPermutation, data)) {
                validCount++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                currentPermutation[depth] = FRIENDS[i];
                generatePermutations(visited, currentPermutation, depth + 1, data);
                visited[i] = false;
            }
        }
    }

    // 주어진 순열이 조건을 만족하는지 확인하는 메소드
    private static boolean isValid(char[] currentPermutation, String[] data) {
        Map<Character, Integer> positionMap = new HashMap<>();
        // 현재 순열에서 각 캐릭터의 위치를 맵에 저장
        for (int i = 0; i < 8; i++) {
            positionMap.put(currentPermutation[i], i);
        }

        // 모든 조건을 확인
        for (String condition : data) {
            char char1 = condition.charAt(0);
            char char2 = condition.charAt(2);
            char operator = condition.charAt(3);
            int requiredDistance = condition.charAt(4) - '0';

            int actualDistance = Math.abs(positionMap.get(char1) - positionMap.get(char2)) - 1;

            if (operator == '=' && actualDistance != requiredDistance) {
                return false;
            } else if (operator == '<' && actualDistance >= requiredDistance) {
                return false;
            } else if (operator == '>' && actualDistance <= requiredDistance) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // 예시 테스트
        System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"})); // 3648
        System.out.println(solution(2, new String[]{"M~C<2", "C~M>1"})); // 0
    }
}
