import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();
        char c;
        double first;
        double second;
        
        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        Map<Character,Double> hm = new HashMap<>();
        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            hm.put((char)(65+i),(double)x);
        }

        
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if('A'<= c && c <= 'Z'){
                stack.push(hm.get(c));
            } else{
                second = stack.pop();
                first = stack.pop();
                stack.push(operator(c,first,second));
            }
            
        }
        System.out.printf("%.2f", stack.pop());
        
    }
    
     static double operator(char c, double first, double second){
            double result=0;
            if(c == '*'){
                result = first * second;
            }
            else if(c == '/'){
                result = first / second;
            }
            else if(c == '-'){
                result = first - second;
            }
            else if(c == '+'){
                result = first + second;
            }
            return result;
        }
}
