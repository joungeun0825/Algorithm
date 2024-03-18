import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Node[] node;
    static int sum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int cnt = Integer.parseInt(reader.readLine());
        
        node = new Node[N];

        for (int i = 0; i < N; i++) {
            node[i] = new Node();
        }

        for(int i=0;i<cnt;i++){
            StringTokenizer parentTokenizer = new StringTokenizer(reader.readLine());
            int first = Integer.parseInt(parentTokenizer.nextToken());
            int second = Integer.parseInt(parentTokenizer.nextToken());
            
            node[first-1].addNetwork(second-1);
            node[second-1].addNetwork(first-1);
        }
        node[0].visited = true;
        int virusComputer = getVirusComputer(0);
        System.out.println(virusComputer);
    }
    static public int getVirusComputer(int index){
        
        for(int i=0; i<node[index].getNetworkSize(); i++){
            if(!node[node[index].network.get(i)].visited){
                
                node[node[index].network.get(i)].visited = true;
                sum += 1;
                getVirusComputer(node[index].network.get(i));
            }
        }
        return sum;
    }
}

class Node{
    List<Integer> network;
    boolean visited;
 
    public Node(){
        this.network = new ArrayList<>();
        this.visited = false;
    }

    public void addNetwork(int network){
        this.network.add(network);
    }
    public List<Integer> getValue() {
        return network;
    }
    public int getNetworkSize(){
        return this.network.size();
    }
 
}
