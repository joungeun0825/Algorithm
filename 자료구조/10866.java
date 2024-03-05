import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deq = new LinkedList<Integer>();

        for(int i=0;i<N;i++){
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            String menu = st.nextToken();
            if(menu.equals("push_front")){
                int x = Integer.parseInt(st.nextToken());
                deq.offerFirst(x);
            }
            else if(menu.equals("push_back")){
                int x = Integer.parseInt(st.nextToken());
                deq.offerLast(x);
            }
            else if(menu.equals("pop_front")){
                if(deq.isEmpty()){
                    sb.append(-1).append('\n');
                }
                else{sb.append(deq.pollFirst()).append('\n');}
            }
            else if(menu.equals("pop_back")){
                if(deq.isEmpty()){
                    sb.append(-1).append('\n');
                }
                else{sb.append(deq.pollLast()).append('\n');}
            }else if(menu.equals("size")){
                sb.append(deq.size()).append('\n');
            }            
            else if(menu.equals("empty")){
                if(deq.isEmpty()){
                    sb.append(1).append('\n');
                }
                else{sb.append(0).append('\n');}
            }
            else if(menu.equals("front")){
                if(deq.peekFirst()==null){
                    sb.append(-1).append('\n');
                }
                else{sb.append(deq.peekFirst()).append('\n');}
            }
            else if(menu.equals("back")){
                if(deq.peekLast()==null){
                    sb.append(-1).append('\n');
                }
                else{sb.append(deq.peekLast()).append('\n');}
            }

        }
        System.out.println(sb);

    }

}
