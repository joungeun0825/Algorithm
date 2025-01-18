import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 국가의 수와 알고 싶은 국가 번호 입력
        int n = sc.nextInt();
        int k = sc.nextInt();

        // 국가별 정보 저장
        int[][] countries = new int[n][4]; // [번호, 금, 은, 동]
        for (int i = 0; i < n; i++) {
            countries[i][0] = sc.nextInt(); // 국가 번호
            countries[i][1] = sc.nextInt(); // 금메달
            countries[i][2] = sc.nextInt(); // 은메달
            countries[i][3] = sc.nextInt(); // 동메달
        }

        // 정렬
        Arrays.sort(countries, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(b[1], a[1]); // 금메달
            if (a[2] != b[2]) return Integer.compare(b[2], a[2]); // 은메달
            return Integer.compare(b[3], a[3]); // 동메달
        });

        // 등수 계산
        int rank = 1; // 현재 등수
        for (int i = 0; i < n; i++) {
            if (i > 0 && !isSame(countries[i], countries[i - 1])) {
                rank = i + 1; // 이전 국가와 메달이 다르면 등수 증가
            }
            if (countries[i][0] == k) {
                System.out.println(rank);
                break;
            }
        }
    }

    // 메달 수가 같은지 비교
    private static boolean isSame(int[] a, int[] b) {
        return a[1] == b[1] && a[2] == b[2] && a[3] == b[3];
    }
}
