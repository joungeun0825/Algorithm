import java.util.*;

public class Main {

    public static class Pair {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 0; t < T; t++) {
            int n = sc.nextInt(); // 문서 개수
            int m = sc.nextInt(); // 목표 문서의 인덱스

            Deque<Pair> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                queue.addLast(new Pair(i, val));
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                Pair current = queue.pollFirst();
                boolean hasHigherPriority = false;

                // 현재 문서보다 높은 우선순위가 있는지 확인
                for (Pair p : queue) {
                    if (p.getValue() > current.getValue()) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.addLast(current); // 우선순위가 높은 문서가 있으므로 뒤로 보냄
                } else {
                    printOrder++; // 인쇄 순서 증가
                    if (current.getIndex() == m) { // 목표 문서라면 출력
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }

        sc.close();
    }
}
