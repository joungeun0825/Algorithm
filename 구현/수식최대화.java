import java.util.*;

public class Solution {
    // 연산자를 기준으로 모든 우선순위 조합을 계산하기 위한 순열 배열
    private static final String[] OPERATORS = {"+", "-", "*"};
    private static List<String[]> permutations = new ArrayList<>();

    // 순열을 구하는 메소드
    private static void generatePermutations(String[] arr, int depth) {
        if (depth == arr.length) {
            permutations.add(arr.clone());
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            generatePermutations(arr, depth + 1);
            swap(arr, depth, i); // 원상복구
        }
    }

    // 배열의 요소를 스왑하는 메소드
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 수식을 계산하는 메소드
    private static long calculate(String[] operators, List<Long> numbers, List<String> ops) {
        List<Long> nums = new ArrayList<>(numbers); // 복사본 생성
        List<String> opList = new ArrayList<>(ops);

        for (String operator : operators) {
            for (int i = 0; i < opList.size(); ) {
                if (opList.get(i).equals(operator)) {
                    long a = nums.remove(i);
                    long b = nums.remove(i);
                    long result = 0;
                    switch (operator) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                    }
                    nums.add(i, result);
                    opList.remove(i); // 해당 연산자를 삭제
                } else {
                    i++; // 다음 연산자로 이동
                }
            }
        }
        return nums.get(0); // 최종 결과 반환
    }

    // 메인 함수
    public static long solution(String expression) {
        // 연산자 우선순위 순열 생성
        generatePermutations(OPERATORS, 0);

        // 숫자와 연산자를 각각 분리
        List<Long> numbers = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        StringBuilder num = new StringBuilder();
        for (char ch : expression.toCharArray()) {
            if (ch == '+' || ch == '-' || ch == '*') {
                numbers.add(Long.parseLong(num.toString()));
                ops.add(String.valueOf(ch));
                num = new StringBuilder();
            } else {
                num.append(ch);
            }
        }
        numbers.add(Long.parseLong(num.toString())); // 마지막 숫자 추가

        long maxResult = 0;

        // 모든 연산자 우선순위 조합에 대해 계산 수행
        for (String[] operatorOrder : permutations) {
            long result = calculate(operatorOrder, numbers, ops);
            maxResult = Math.max(maxResult, Math.abs(result)); // 절댓값 비교
        }

        return maxResult;
    }

}
