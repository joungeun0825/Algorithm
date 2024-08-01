class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            // n 자릿수의 2진수 문자열로 변환
            String binaryStr1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i]));
            String binaryStr2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i]));
            
            StringBuilder newStr = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(binaryStr1.charAt(j) == '1' || binaryStr2.charAt(j) == '1') {
                    newStr.append("#");
                } else {
                    newStr.append(" ");
                }
            }
            answer[i] = newStr.toString();
        }
        
        return answer;
    }
}
