import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    public int solution(String dartResult) {
        List<Integer> scores = new ArrayList<>();
        int len = dartResult.length();
        int idx = 0;
        
        while (idx < len) {
            int score = 0;
            if (dartResult.charAt(idx) == '1' && dartResult.charAt(idx + 1) == '0') {
                score = 10;
                idx += 2;
            } else {
                score = dartResult.charAt(idx) - '0';
                idx++;
            }
            
            char bonus = dartResult.charAt(idx++);
            switch (bonus) {
                case 'S':
                    score = (int) Math.pow(score, 1);
                    break;
                case 'D':
                    score = (int) Math.pow(score, 2);
                    break;
                case 'T':
                    score = (int) Math.pow(score, 3);
                    break;
            }
            
            if (idx < len && (dartResult.charAt(idx) == '*' || dartResult.charAt(idx) == '#')) {
                char option = dartResult.charAt(idx++);
                if (option == '*') {
                    score *= 2;
                    if (!scores.isEmpty()) {
                        scores.set(scores.size() - 1, scores.get(scores.size() - 1) * 2);
                    }
                } else if (option == '#') {
                    score *= -1;
                }
            }
            
            scores.add(score);
        }
        
        int totalScore = 0;
        for (int sc : scores) {
            totalScore += sc;
        }
        
        return totalScore;
    }
}
