import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long newPoint = sc.nextLong();
        int P = sc.nextInt();

        List<Long> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(sc.nextLong());
        }

        int rank = 1;
        for(long point : points) {
            if(point > newPoint) {
                rank++;
            }
        }

        int cnt = 0;
        for(long point : points) {
            if(point == newPoint) {
                cnt++;
            }
        }

        if(rank+cnt>P){
            System.out.println(-1);
        }else{
            System.out.println(rank);
        }
    }
}
