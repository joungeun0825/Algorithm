import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int j_money = Integer.parseInt(br.readLine());
        int s_money = j_money;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int j_coin = 0; 
        int s_coin = 0;
        
        int before = Integer.parseInt(st.nextToken());
        if(j_money>before){
            j_coin += j_money / before;
            j_money %= before;
        }
        
        int now = 0;
        int high = 0;
        int down = 0;
        for(int i=2; i<=14; i++){
            now = Integer.parseInt(st.nextToken());
            if(j_money>=now){
                j_coin += j_money / now;
                j_money %= now;
            }
            if(now>before){
                high += 1;
                down = 0;
                if(high == 3){
                    s_money += now * s_coin;
                    s_coin = 0;
                    high = 0;
                }
            }else if(now<before){
                down += 1;
                high = 0;
                if(down == 3){
                    if(s_money>=now){
                        s_coin += s_money/now;
                        s_money %= now;
                    }
                    down = 0;
                }
            }
            before = now;
        }
        j_money += now * j_coin;
        s_money += now * s_coin;
        if(j_money>s_money){
            System.out.println("BNP");
        }else if(j_money<s_money){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }
    }
}
