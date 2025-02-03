import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt(); // 사용되지 않으므로 삭제 가능

        // secretKey와 userKey를 문자열로 변환
        StringBuilder secretKey = new StringBuilder();
        for (int i = 0; i < m; i++) {
            secretKey.append(sc.nextInt()).append(" ");
        }

        StringBuilder userKey = new StringBuilder();
        for (int i = 0; i < n; i++) {
            userKey.append(sc.nextInt()).append(" ");
        }

        // 부분 문자열로 탐색
        if (userKey.toString().contains(secretKey.toString())) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}
