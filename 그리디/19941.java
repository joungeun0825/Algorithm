import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 처리
        int N = sc.nextInt(); // 문자열 길이
        int K = sc.nextInt(); // 사람(P)과 햄버거(H)의 최대 거리
        sc.nextLine(); // 개행 문자 제거
        String str = sc.nextLine(); // 문자열 입력

        // 배열 변환
        char[] arr = str.toCharArray();
        int cnt = 0; // 먹은 햄버거 개수

        for (int i = 0; i < N; i++) {
            // 현재 위치가 'P'(사람)일 경우
            if (arr[i] == 'P') {
                // K 거리 내에서 햄버거 찾기
                int leftBound = Math.max(0, i - K); // 왼쪽 경계
                int rightBound = Math.min(N - 1, i + K); // 오른쪽 경계

                for (int j = leftBound; j <= rightBound; j++) {
                    if (arr[j] == 'H') { // 햄버거 발견
                        arr[j] = '-'; // 먹은 햄버거 처리
                        cnt++; // 카운트 증가
                        break; // 다음 사람으로 이동
                    }
                }
            }
        }

        System.out.println(cnt); // 결과 출력
    }
}
