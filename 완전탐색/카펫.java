class Solution {
    public int[] solution(int brown, int yellow) {
        int idx = 1;
        while(true){
            int tmp = yellow;
            tmp /= idx;
            if((tmp*2 + idx*2 + 4) == brown && yellow % idx == 0){
                return new int[] {tmp+2, idx+2};
            }
            idx++;
        }
    }
}
