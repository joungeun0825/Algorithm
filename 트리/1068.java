import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, target, root;
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        tree = new Node[N];
        StringTokenizer parentTokenizer = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; i++){
            int parent = Integer.parseInt(parentTokenizer.nextToken());
            tree[i] = new Node(parent);
            if(parent<0) root = i;
        }
        target = Integer.parseInt(reader.readLine());
        reader.close();
        for(int i=0; i<N; i++){
            if(!tree[i].isRoot()){
                int parent = tree[i].parent;
                tree[parent].addChild(i);
            }
        }
        if(target == root){
            System.out.println(0);
        }else{
            int parent = tree[target].parent;
            tree[parent].removeChild(target);
            int leafSize = getLeafSize(root);
            System.out.println(leafSize);
        }
    }

    static int getLeafSize(int index){
        if(tree[index].isLeaf()) return 1;
        int sum = 0;
        for(int i=0; i<tree[index].getChildrenSize(); i++){
            sum += getLeafSize(tree[index].children.get(i));
        }
        return sum;
    }
}
class Node{
    int parent;
    List<Integer> children;

    public Node(int parent){
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public void addChild(int child){
        this.children.add(child);
    }

    public void removeChild(int child){
        this.children.remove(Integer.valueOf(child));
    }

    public boolean isLeaf(){
        return this.children.isEmpty();
    }

    public int getChildrenSize(){
        return this.children.size();
    }

    public boolean isRoot(){
        return this.parent < 0;
    }
}
