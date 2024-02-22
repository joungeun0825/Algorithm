import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

class IntStack{
    private int[] stk;
    private int capacity;
    private int ptr;

    //생성자
    public IntStack(int maxlen){
        ptr = 0;
        capacity = maxlen;
        stk = new int[capacity];
    }

    public void push(int x){
        stk[ptr++] = x;
    }

    public int pop(){
        if(ptr <= 0)
            return -1;
        else return stk[--ptr];
    }

    public int empty(){
        if(ptr <= 0)
            return 1;
        else return 0;
    }

    public int top(){
        if(ptr <= 0)
            return -1;
        else return stk[ptr - 1];
    }
    
    public int size(){
        return ptr;
    }
}
class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        Integer order = stdIn.nextInt();
        IntStack s = new IntStack(order);
        
        for(int i = 0; i < order; i++){
            String menu = stdIn.next();
            if(menu.equals("push")){
                Integer x = stdIn.nextInt();
                s.push(x);
            }
            else if(menu.equals("pop")){
                //System.out.println(s.pop());
                sb.append(s.pop()).append('\n');
            }
            else if(menu.equals("size")){
                //System.out.println(s.size());
                sb.append(s.size()).append('\n');
            }
            else if(menu.equals("empty")){
                //System.out.println(s.empty());
                sb.append(s.empty()).append('\n');
            }
            else if(menu.equals("top")){
                //System.out.println(s.top());
                sb.append(s.top()).append('\n');
            }
        }
        System.out.println(sb);
        
    }
}
