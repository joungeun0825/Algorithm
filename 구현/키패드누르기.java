import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, int[]> list = new HashMap<>();
        list.put(1, new int[]{0, 0});
        list.put(2, new int[]{0, 1});
        list.put(3, new int[]{0, 2});
        list.put(4, new int[]{1, 0});
        list.put(5, new int[]{1, 1});
        list.put(6, new int[]{1, 2});
        list.put(7, new int[]{2, 0});
        list.put(8, new int[]{2, 1});
        list.put(9, new int[]{2, 2});
        list.put(0, new int[]{3, 1});

        int[] left = {3, 0}; // '*' 위치
        int[] right = {3, 2}; // '#' 위치

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                left = list.get(number);
                answer.append('L');
            } else if (number == 3 || number == 6 || number == 9) {
                right = list.get(number);
                answer.append('R');
            } else {
                int[] target = list.get(number);
                int lDist = Math.abs(target[0] - left[0]) + Math.abs(target[1] - left[1]);
                int rDist = Math.abs(target[0] - right[0]) + Math.abs(target[1] - right[1]);

                if (lDist < rDist) {
                    left = target;
                    answer.append('L');
                } else if (rDist < lDist) {
                    right = target;
                    answer.append('R');
                } else {
                    if (hand.equals("left")) {
                        left = target;
                        answer.append('L');
                    } else {
                        right = target;
                        answer.append('R');
                    }
                }
            }
        }
        return answer.toString();
    }
}
