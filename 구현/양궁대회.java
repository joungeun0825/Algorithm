import java.util.*;

class Solution {
    private int maxDiff = 0;
    private int[] bestAnswer;

    public int[] solution(int n, int[] info) {
        bestAnswer = new int[11];
        Arrays.fill(bestAnswer, -1);
        
        // DFS 탐색 시작
        dfs(n, info, new int[11], 0);
        
        // 라이언이 우승할 방법이 없는 경우
        if (maxDiff == 0) {
            return new int[]{-1};
        }
        return bestAnswer;
    }

    private void dfs(int arrowsLeft, int[] apeach, int[] ryan, int idx) {
        if (idx == 11 || arrowsLeft == 0) {
            // 마지막 과녁에 남은 화살 처리
            if (arrowsLeft > 0) {
                ryan[10] += arrowsLeft;
            }

            int apeachScore = 0;
            int ryanScore = 0;
            
            for (int i = 0; i < 11; i++) {
                if (ryan[i] > apeach[i]) {
                    ryanScore += 10 - i;
                } else if (apeach[i] > 0) {
                    apeachScore += 10 - i;
                }
            }

            int scoreDiff = ryanScore - apeachScore;
            if (scoreDiff > maxDiff) {
                maxDiff = scoreDiff;
                bestAnswer = Arrays.copyOf(ryan, 11);
            } else if (scoreDiff == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > bestAnswer[i]) {
                        bestAnswer = Arrays.copyOf(ryan, 11);
                        break;
                    } else if (ryan[i] < bestAnswer[i]) {
                        break;
                    }
                }
            }
            
            // 마지막 과녁에서 남은 화살 처리 복원
            if (arrowsLeft > 0) {
                ryan[10] -= arrowsLeft;
            }
            return;
        }
        
        // 이번 점수를 포기하고 넘어가는 경우
        dfs(arrowsLeft, apeach, ryan, idx + 1);
        
        // 이번 점수를 라이언이 이기기 위해 화살을 사용하는 경우
        if (arrowsLeft > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            dfs(arrowsLeft - ryan[idx], apeach, ryan, idx + 1);
            ryan[idx] = 0; // 상태 복원
        }
    }
}
