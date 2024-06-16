import java.util.*;
import java.io.*;

class Main {
    static int[] switches;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 스위치 개수 입력
        N = Integer.parseInt(br.readLine());
        
        // 스위치 상태 입력
        switches = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 수 입력
        int students = Integer.parseInt(br.readLine());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int switch_num = Integer.parseInt(st.nextToken());
            changeSwitch(gender, switch_num);
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

    // 스위치 상태 변경 메소드
    public static void changeSwitch(int gender, int switch_num) {
        if (gender == 1) {
            // 남학생의 경우: 해당 번호의 배수인 스위치의 상태를 변경
            for (int i = switch_num; i <= N; i += switch_num) {
                switches[i] = 1 - switches[i];
            }
        } else if (gender == 2) {
            // 여학생의 경우: 좌우 대칭 구간의 스위치 상태를 변경
            switches[switch_num] = 1 - switches[switch_num];
            int left = switch_num - 1;
            int right = switch_num + 1;

            while (left > 0 && right <= N && switches[left] == switches[right]) {
                switches[left] = 1 - switches[left];
                switches[right] = 1 - switches[right];
                left--;
                right++;
            }
        }
    }
}
