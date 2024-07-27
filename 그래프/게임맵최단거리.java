import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0,0,1});
        while(!queue.isEmpty()){
            int now[] = queue.poll();
            if(now[0]==maps.length-1&&now[1]==maps[0].length-1){
                return now[2];
            }
            for(int i = 0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(0<=x&&x<maps.length&&0<=y&&y<maps[0].length&&maps[x][y]==1){
                    maps[now[0]][now[1]]=0; 
                    queue.add(new int[] {x,y,now[2]+1});
                }
                
            }
        }
        return -1;
    }
}
