import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stk = new Stack<>();
        String s = br.readLine();
        
        int total = 0;
        int tmp = 1;
        for(int i=0;i<s.length();i++){
            Character now = s.charAt(i);
            if(now == '('){
                stk.push(now);
                tmp *= 2;
            }
            else if(now == '['){
                stk.push(now);
                tmp *= 3;
            }
            else if(now == ')'){
                if(stk.isEmpty() ||stk.peek()!='('){
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1)=='('){
                    total+=tmp;
                }
                stk.pop();
                tmp/=2;
            }
            else if(now == ']'){
                if(stk.isEmpty()||stk.peek()!='['){
                    System.out.println(0);
                    return;
                }
                if(s.charAt(i-1)=='['){
                    total+=tmp;
                }
                stk.pop();
                tmp/=3;
            }
        }
        if(!stk.isEmpty()) System.out.println(0);
        else System.out.println(total);        
        
    }
    


}


    
