class Solution {
    int max = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(0, dungeons, k, visited);
        return max;
    }

    public void dfs(int cnt, int[][] dungeons, int gaze, boolean[] visited) {
        max = Math.max(max, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && gaze >= dungeons[i][0]) {
                visited[i] = true;
                dfs(cnt + 1, dungeons, gaze - dungeons[i][1], visited);
                visited[i] = false;
            }
        }
    }
}
