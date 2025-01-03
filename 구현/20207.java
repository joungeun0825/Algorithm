import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 일정 개수 입력
        int n = sc.nextInt();
        int[][] schedules = new int[n][2];

        // 일정 입력
        for (int i = 0; i < n; i++) {
            schedules[i][0] = sc.nextInt(); // 시작 날짜
            schedules[i][1] = sc.nextInt(); // 종료 날짜
        }

        // 일정 정렬 (시작 날짜 오름차순, 시작 날짜가 같으면 종료 날짜 내림차순)
        Arrays.sort(schedules, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        // 날짜별 최대 높이 저장
        int[] height = new int[366];

        for (int[] schedule : schedules) {
            int start = schedule[0];
            int end = schedule[1];
            for (int day = start; day <= end; day++) {
                height[day]++;
            }
        }

        // 면적 계산
        int totalArea = 0;
        int maxHeight = 0, start = 0;

        for (int day = 1; day <= 365; day++) {
            if (height[day] > 0) {
                if (start == 0) start = day; // 시작 날짜 기록
                maxHeight = Math.max(maxHeight, height[day]);
            } else {
                if (start > 0) {
                    // 직사각형 면적 추가
                    totalArea += maxHeight * (day - start);
                    maxHeight = 0;
                    start = 0;
                }
            }
        }

        // 마지막 직사각형 처리
        if (start > 0) {
            totalArea += maxHeight * (365 - start + 1);
        }

        // 결과 출력
        System.out.println(totalArea);
    }
}
