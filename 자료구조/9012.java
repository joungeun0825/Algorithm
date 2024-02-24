import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Stack;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        
        int N = std.nextInt();
		
		for(int i = 0; i < N; i++) {
			System.out.println(solve(std.next()));
		}
    }

    public static String solve(String s){
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if (c == '(') {
				stack.push(c);
			}
        else if(stack.empty()){
            return "NO";
        }
        else{
            stack.pop();
        }
    }
    if(stack.empty()){
        return "YES";
    }
    else{
        return "NO";
    }
        
    
}
}

