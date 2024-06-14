import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] chulsu;
    static int[] row,col;
    static int cnt,cross,rcross,result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        chulsu = new int[5][5];
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                chulsu[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 1;
        row = new int[] {0,0,0,0,0};
        col = new int[] {0,0,0,0,0};
        cross = 0;
        rcross = 0;
        result = 0;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                bingo(Integer.parseInt(st.nextToken()));
                if(result>=3){
                    System.out.println(cnt);
                    return;
                }
                cnt+=1;
            }
        }
        
    }

     public static void bingo(int n){
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			if(chulsu[i][j] == n) {
    				col[i] += 1;
                    row[j] += 1;
                    if(i==j && i!=2 && j !=2){
                        cross += 1;
                    }else if(i+j==4&& i!=2 && j !=2){
                        rcross += 1;
                    }else if(i == 2 && j ==2){
                        cross += 1;
                        rcross += 1;
                    }
                    check(i,j);
    			}
    		}
    	}
    }

    public static void check(int i, int j){
        if(col[i]==5){
            col[i] = 0;
            result += 1;
        }
        if(row[j]==5){
            row[j] = 0;
            result += 1;
        }
        if(cross==5){
            cross = 0;
            result += 1;
        }
        if(rcross==5){
            rcross = 0;
            result += 1;
        }
    }

}
