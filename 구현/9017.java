import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int players = sc.nextInt();
            List<Integer> pointList = removeInvalidTeam(players);
            Map<Integer, List<Integer>> points = givePoints(pointList);
            System.out.println(findWinner(points));
        }
    }

    private static List<Integer> removeInvalidTeam(int players) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < players; i++) {
            int now = sc.nextInt();
            list.add(now);
            map.put(now, map.getOrDefault(now, 0) + 1);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int team = iterator.next();
            if (map.get(team) < 6) {
                iterator.remove(); // 유효하지 않은 팀 제거
            }
        }

        return list;
    }

    private static Map<Integer, List<Integer>> givePoints(List<Integer> pointList) {
        Map<Integer, List<Integer>> points = new HashMap<>();
        for (int i = 0; i < pointList.size(); i++) {
            int team = pointList.get(i);
            points.putIfAbsent(team, new ArrayList<>());
            points.get(team).add(i + 1); // 등수를 저장
        }
        return points;
    }

    private static int findWinner(Map<Integer, List<Integer>> map) {
        int winner = -1;
        int minValue = Integer.MAX_VALUE;
        int fifthPlayer = Integer.MAX_VALUE;

        for (Integer team : map.keySet()) {
            List<Integer> points = map.get(team);
            if (points.size() < 5) continue; // 점수가 부족한 팀 제외

            int sum = points.get(0) + points.get(1) + points.get(2) + points.get(3);
            int currentFifthPlayer = points.get(4);

            if (sum < minValue || (sum == minValue && currentFifthPlayer < fifthPlayer)) {
                winner = team;
                minValue = sum;
                fifthPlayer = currentFifthPlayer;
            }
        }

        return winner;
    }
}
