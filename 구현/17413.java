import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String original = br.readLine();
        original += ' ';
        StringBuffer newStr = new StringBuffer("");
        int idx = 0;

        while(idx<original.length()){
            if(original.charAt(idx) == '<'){
                do{
                    newStr.append(original.charAt(idx));
                    idx++;
                }while(original.charAt(idx)!='>');
                newStr.append(original.charAt(idx));
                idx++;
            }else if(original.charAt(idx) == ' '){
                newStr.append(' ');
                idx++;
            }else{
                StringBuffer tmpStr = new StringBuffer("");
                do{
                    tmpStr.append(original.charAt(idx));
                    idx++;
                }while(original.charAt(idx) != '<' && original.charAt(idx) != ' ');
                newStr.append(tmpStr.reverse().toString());
            }
        }
        
        System.out.println(newStr);
        
    }
    
}
