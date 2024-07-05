import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int direction = sc.nextInt();

        for (int i=0; i<len; i++) {
            String s = sc.next();
            String str = "";
            for (int j = 0; j<len; j++) {
                char c = s.charAt(j);
                if(direction == 1){
                    if(c == 'd'){
                        str += "q";
                    }else if(c == 'b'){
                        str += "p";
                    }else if(c == 'q'){
                        str += "d";
                    }else if(c == 'p'){
                        str += "b";
                    }
                }else{
                    if(c == 'd'){
                        str += "b";
                    }else if(c == 'b'){
                        str += "d";
                    }else if(c == 'q'){
                        str += "p";
                    }else if(c == 'p'){
                        str += "q";
                    }
                }
            }
            System.out.println(str);
        }
    }
}
