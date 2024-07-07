import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 첫 줄 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 초기 배열의 크기
        int M = Integer.parseInt(st.nextToken()); // 감소할 값
        int K = Integer.parseInt(st.nextToken()); // K보다 큰 값이 될 때까지 추가할 값
        
        // 작업의 중요도 배열 입력 받기
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        
        // 처리된 결과를 저장할 리스트
        List<Integer> newarr = new ArrayList<>();
        int Y = 0;
        while (!pq.isEmpty()) {
            int maxVal = pq.poll();
            newarr.add((Y / 2) + maxVal);
            Y = (Y / 2) + maxVal;

            int newVal = maxVal - M;
            if (newVal > K) {
                pq.offer(newVal);
            }
        }
        
        // 결과 출력
        bw.write(newarr.size() + "\n");
        for (int a : newarr) {
            bw.write(a + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
