import java.util.*;
import java.lang.*;
import java.io.*;

class MyQueue{
    
    private int front;
    private int rear;
    private int num;
    private int capacity;
    private int[] que;

    public MyQueue(int maxCapacity){
        num = front = rear = 0;
        capacity = maxCapacity;
        que = new int[capacity];
    }
     
    public int enque(int x){
        que[rear++] = x;
        num++;
        if(rear == capacity)
            rear = 0;
        return x;
    }

    public int deque(){
        if(num <= 0)
            return -1;
        else{
            int x = que[front++];
            num--;
            if(front == capacity)
                front = 0;
            return x;
        }
        
    }

    public int size(){
        return num; 
    }

    public int empty(){
        if(num <= 0)
            return 1;
        else
            return 0;
    }
    public int front(){
        if(num <= 0)
            return -1;
        else
            return que[front];
    }
    public int back(){
        if(num <= 0)
            return -1;
        else
            return que[rear-1];
    }
}
// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        MyQueue q = new MyQueue(N);

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
			String menu = st.nextToken();
            if(menu.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                q.enque(x);
            }
            else if(menu.equals("pop")){
                sb.append(q.deque()).append('\n');
            }
            else if(menu.equals("size")){
                sb.append(q.size()).append('\n');
            }
            else if(menu.equals("empty")){
                sb.append(q.empty()).append('\n');
            }
            else if(menu.equals("front")){
                sb.append(q.front()).append('\n');
            }
            else if(menu.equals("back")){
                sb.append(q.back()).append('\n');
            }
        }
        System.out.println(sb);
        
    }
}
