import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Player[] players = new Player[n];

        // Player 객체 생성
        for (int i = 0; i < n; i++) {
            players[i] = new Player(i); // 각 플레이어에 고유 ID 부여
        }

        // 각 경기별 기록 입력
        for (int race = 0; race < 3; race++) {
            st = new StringTokenizer(br.readLine());
            for (int player = 0; player < n; player++) {
                int record = Integer.parseInt(st.nextToken());
                players[player].updateRecord(race, record);
            }
        }

        // 각 경기별 랭킹 설정
        for (int race = 0; race < 3; race++) {
            final int raceIndex = race; // 람다식에서 사용하기 위한 final 변수
            Arrays.sort(players, (a, b) -> Integer.compare(b.getRecord(raceIndex), a.getRecord(raceIndex))); // 내림차순 정렬
            for (int rank = 0; rank < n; rank++) {
                if (rank > 0 && players[rank].getRecord(race) == players[rank - 1].getRecord(race)) {
                    // 동점자 처리: 이전 사람과 같은 등수 부여
                    players[rank].updateRank(race, players[rank - 1].getRank(race));
                } else {
                    players[rank].updateRank(race, rank + 1); // 1등부터 시작
                }
            }
        }

        // 총합 기록 기준으로 최종 정렬
        Arrays.sort(players, (a, b) -> Integer.compare(b.getAllRecordSum(), a.getAllRecordSum())); // 내림차순 정렬

        // 최종 등수 계산
        for (int rank = 0; rank < n; rank++) {
            if (rank > 0 && players[rank].getAllRecordSum() == players[rank - 1].getAllRecordSum()) {
                // 동점자 처리: 이전 사람과 같은 등수 부여
                players[rank].updateFinalRank(players[rank - 1].getFinalRank());
            } else {
                players[rank].updateFinalRank(rank + 1); // 1등부터 시작
            }
        }

        // 원래 순서대로 정렬 (입력 순서 복원)
        Arrays.sort(players, Comparator.comparingInt(Player::getId));

        // 출력
        // 각 대회별 등수 출력
        for (int race = 0; race < 3; race++) {
            for (int player = 0; player < n; player++) {
                sb.append(players[player].getRank(race)).append(" ");
            }
            sb.append("\n");
        }
        // 최종 등수 출력
        for (int player = 0; player < n; player++) {
            sb.append(players[player].getFinalRank()).append(" ");
        }

        // 결과 출력
        System.out.println(sb);
    }

    static class Player {
        int id; // 플레이어 고유 ID
        int[] records; // 각 대회별 점수
        int[] ranks; // 각 대회별 등수
        int finalRank; // 최종 등수

        Player(int id) {
            this.id = id;
            this.records = new int[3];
            this.ranks = new int[3];
            this.finalRank = 0;
        }

        public void updateRecord(int race, int record) {
            this.records[race] = record;
        }

        public void updateRank(int race, int rank) {
            this.ranks[race] = rank;
        }

        public void updateFinalRank(int finalRank) {
            this.finalRank = finalRank;
        }

        public int getRecord(int race) {
            return this.records[race];
        }

        public int getRank(int race) {
            return this.ranks[race];
        }

        public int getFinalRank() {
            return this.finalRank;
        }

        public int getAllRecordSum() {
            return this.records[0] + this.records[1] + this.records[2];
        }

        public int getId() {
            return this.id;
        }
    }
}
