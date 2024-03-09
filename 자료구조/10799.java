import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stk = new Stack<>();
        String s = br.readLine();
        
        int stick = 0;
        int total = stick;
        Character prev = ' ';
        for(int i=0;i<s.length();i++){
            Character now = s.charAt(i);
            if(now=='('){
                stick += 1;
                total += 1;
                stk.push('(');
            }
            else if(now==')'){
                stick -= 1;
                if(prev=='('){
                    total -= 1;
                    total += stick;
                }
                stk.pop();               
            }
            prev = now;
    
        }
        System.out.println(total);          
        
    }
    


}


    
