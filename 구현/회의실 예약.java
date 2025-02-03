import java.io.*;
import java.util.*;

public class Main {
    public static class Room {
        String name;
        boolean[] times = new boolean[19];

        Room(String name) {
            this.name = name;
        }

        void addTime(int ft, int tt) {
            for (int t = ft; t < tt; t++) {
                times[t] = true;
            }
        }

        String toStringResult() {
            String s = "Room " + this.name + ":" + "\n";
            s += toStringTimes();
            return s;
        }

        private String toStringTimes() {
            List<int[]> vt = findValidTimes();
            if (vt.isEmpty()) {
                return "Not available";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(vt.size()).append(" available:\n");
            for (int[] t : vt) {
                sb.append(String.format("%02d-%02d\n",t[0],t[1]));
            }
            return sb.toString();
        }

        private List<int[]> findValidTimes() {
            List<int[]> vtimes = new ArrayList<>();
            int t = 9;
            while (t <= 18) {
                if (times[t] == false) {
                    int st = t;
                    while (true) {
                        if (t == 18 || times[t] == true) {
                            if(st<18){
                                vtimes.add(new int[]{st, t});
                            }
                            break;
                        }
                        t++;
                    }
                }
                t++;
            }
            return vtimes;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<String, Room> rooms = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            rooms.put(name, new Room(name));
        }

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            int fromTime = sc.nextInt();
            int toTime = sc.nextInt();
            rooms.get(name).addTime(fromTime, toTime);
        }

        int count = 0;
        for (Room room:rooms.values()) {
            System.out.println(room.toStringResult());
            if (count < n - 1) {
                System.out.println("-----");
            }
            count++;
        }
    }
}
