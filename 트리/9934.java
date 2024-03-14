import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] node;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int cnt = (int)Math.pow(2,K)-1;
        node = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < node.length; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

        Map<Integer, List<Integer>> map = new HashMap<>(); 
        search(0,cnt-1,0,map);

        for (Integer i : map.keySet()) {
			List<Integer> list = map.get(i);
			
			for (Integer is : list) {
				System.out.print(is + " ");
			}
			System.out.println();
		}
    }

    static void search(int start, int end, int level, Map<Integer, List<Integer>> map){
        int mid = (start + end)/2;
        List<Integer> newList = map.getOrDefault(level, new ArrayList<Integer>());
        newList.add(node[mid]);
        map.put(level,newList);

        if(start == end) return;
        
        search(start,mid-1,level+1,map);
        search(mid+1,end,level+1,map);
        
    }
}
