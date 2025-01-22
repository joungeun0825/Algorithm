import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        int N = sc.nextInt(); // 단어 개수
        int M = sc.nextInt(); // 외울 단어의 최소 길이
        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            if (word.length() >= M) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // 리스트로 변환
        List<Word> wordList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            wordList.add(new Word(entry.getKey(), entry.getValue()));
        }

        // 정렬
        wordList.sort((a, b) -> {
            if (a.count != b.count) return Integer.compare(b.count, a.count); // 출현 횟수 내림차순
            if (a.word.length() != b.word.length()) return Integer.compare(b.word.length(), a.word.length()); // 길이 내림차순
            return a.word.compareTo(b.word); // 알파벳 사전순
        });

        // 출력
        StringBuilder sb = new StringBuilder();
        for (Word word : wordList) {
            sb.append(word.word).append("\n");
        }
        System.out.println(sb);
    }

    // 단어 객체 정의
    static class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
