import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main{

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Scanner st = new Scanner(System.in);

        int out_node = -1;
        int in_node = -1;
        int K = 0;
        while(true){
            
            out_node = st.nextInt();
            in_node = st.nextInt();
            
            //-1 -1 면 종료
            if(out_node==-1 && in_node==-1){
                    return;
            }
            else{
                if(out_node == 0 && in_node ==0){
                    K++;
                    int root = 0;
                    int v_cnt = 0;
                    Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
                    for(Map.Entry<Integer, Integer> entry : entrySet){
                        if(entry.getValue()==0){
                            root += 1;
                        }
                        if(entry.getValue()==1){
                            v_cnt += 1;
                        }
                    }
                    if(entrySet.size()==0){
                        System.out.println("Case "+K+" is a tree.");
                    }
                    else if(root == 1 && v_cnt == entrySet.size()-1){
                        System.out.println("Case "+K+" is a tree.");
                    }
                    else System.out.println("Case "+K+" is not a tree.");
                    map = new HashMap<Integer, Integer>();
                }
                else if(out_node != 0 && in_node !=0){
                    if(!map.containsKey(out_node)){
                        map.put(out_node,0);
                    }
                    if(!map.containsKey(in_node)){
                        map.put(in_node,1);
                    }
                    else if(map.containsKey(in_node)){
                        map.put(in_node, map.get(in_node)+1);
                    }
                                        
                }

            }
            

        }
        
        
    }
    
}


    
