import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int candidateNum = sc.nextInt();
        String game = sc.next();
        int playerNum = 0;
        Set<String> players = new HashSet<>();

        if (game.equals("Y")) {
            playerNum = 2;
        } else if (game.equals("F")) {
            playerNum = 3;
        } else if (game.equals("O")) {
            playerNum = 4;
        }

        int playCnt = 0;
        int playerCnt = 0;
        for (int i = 0; i < candidateNum; i++) {
            String player = sc.next();
            if (players.add(player)) {
                playerCnt++;
                if (playerNum - 1 == playerCnt) {
                    playCnt++;
                    playerCnt = 0;
                }
            }
        }

        System.out.println(playCnt);
    }
}
