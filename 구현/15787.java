import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trainCnt = sc.nextInt();
        int commandCnt = sc.nextInt();

        boolean[][] train = new boolean[trainCnt][20];
        for (int i = 0; i < commandCnt; i++) {
            int command = sc.nextInt();
            if (command == 1) {
                int trainNum = sc.nextInt() - 1;
                int seatNum = sc.nextInt() - 1;
                train[trainNum][seatNum] = true;
            } else if (command == 2) {
                int trainNum = sc.nextInt() - 1;
                int seatNum = sc.nextInt() - 1;
                train[trainNum][seatNum] = false;
            } else if (command == 3) {
                int trainNum = sc.nextInt() - 1;
                Deque<Boolean> trainQueue = convertToDeque(train[trainNum]);
                trainQueue.pollLast();
                trainQueue.addFirst(false);
                train[trainNum] = convertToArray(trainQueue);
            } else if (command == 4) {
                int trainNum = sc.nextInt() - 1;
                Deque<Boolean> trainQueue = convertToDeque(train[trainNum]);
                trainQueue.pollFirst();
                trainQueue.addLast(false);
                train[trainNum] = convertToArray(trainQueue);
            }
        }

        Set<String> uniqueTrains = new HashSet<>();
        for (int i = 0; i < trainCnt; i++) {
            uniqueTrains.add(Arrays.toString(train[i]));
        }
        System.out.println(uniqueTrains.size());
    }

    private static Deque<Boolean> convertToDeque(boolean[] train) {
        Deque<Boolean> trainQueue = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            trainQueue.add(train[i]);
        }
        return trainQueue;
    }

    private static boolean[] convertToArray(Deque<Boolean> trainQueue) {
        boolean[] train = new boolean[20];
        for (int i = 0; i < 20; i++) {
            train[i] = trainQueue.pollFirst();
        }
        return train;
    }
}
