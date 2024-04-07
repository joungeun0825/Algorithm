import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Node{
        int num;
        Node left, right;

        Node(int num){
            this.num = num;
        }

        Node(int num, Node right, Node left){
            this.num = num;
            this.right = right;
            this.left = left;
        }

        void insert(int n){
            if(this.num > n){
                if(this.left == null){
                    this.left = new Node(n);
                }
                else this.left.insert(n);
            }else{
                if(this.right == null){
                    this.right = new Node(n);
                }
                else this.right.insert(n);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        String s;

        while (true) {
            s = br.readLine();
            if(s==null || s==""){
                break;
            }
            root.insert(Integer.parseInt(s));
        }
        postOrder(root);
    }
    
    static void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
        
    }
}
