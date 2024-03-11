import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            try{
                list.add(Integer.parseInt(st.nextToken()));
            } catch(NumberFormatException e){

            } catch(Exception e){

            }
            
        }       
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int q=j+1;q<N;q++){
                    int sum = list.get(i)+list.get(j)+list.get(q);
                    if(sum <=M && sum > max){
                        max = sum;
                    }
                }
            }
        }
        System.out.println(max);
        
    }
    


}


    
