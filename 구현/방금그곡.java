class Solution {
    
    // 멜로디에서 C#과 같은 음들을 치환하는 함수
    public String convertMelody(String ms){
        return ms.replace("C#", "c")
                 .replace("D#", "d")
                 .replace("F#", "f")
                 .replace("G#", "g")
                 .replace("A#", "a")
                 .replace("B#", "b");
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxMusicLen = -1;  // 가장 긴 재생 시간을 저장할 변수
        m = convertMelody(m);  // 기억한 멜로디 변환
        
        for (String musicinfo : musicinfos) {
            String[] cm = musicinfo.split(",");
            int ft = Integer.parseInt(cm[1].split(":")[0]) * 60 + Integer.parseInt(cm[1].split(":")[1]); // 종료 시간
            int st = Integer.parseInt(cm[0].split(":")[0]) * 60 + Integer.parseInt(cm[0].split(":")[1]); // 시작 시간
            int musicLen = ft - st;  // 재생 시간
            
            String ms = convertMelody(cm[3]); // 악보 변환
            
            // 악보를 반복해서 재생 시간만큼 문자열 생성
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < musicLen; i++) {
                str.append(ms.charAt(i % ms.length()));
            }
            
            // 기억한 멜로디가 포함되어 있는지 확인
            if (str.toString().contains(m)) {
                // 가장 긴 곡을 선택
                if (musicLen > maxMusicLen) {
                    maxMusicLen = musicLen;
                    answer = cm[2]; // 제목을 갱신
                }
            }
        }
        return answer;
    }
}
