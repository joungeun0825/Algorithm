import java.util.*;
import java.io.*;

class Main {
    static ArrayList<int[]> list = new ArrayList<>();
    static int K;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        if(K <= 1){
            System.out.println(0);
            return;
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = new int[K];
        cb(arr, N, 1, 0);

        int max = Integer.MIN_VALUE;
        for (int[] array : list) {
            int[] na = new int[2];
            ArrayList<int[]> subList = new ArrayList<>();
            ArrayList<Integer> lastList = new ArrayList<>();
            check(na, array, 0, 0, subList);
            for (int[] a : subList) {
                lastList.add(map[a[0] - 1][a[1] - 1]);
            }
            Collections.sort(lastList, Comparator.reverseOrder());
            int ans = 0;
            for(int i = 0; i < lastList.size(); i++) {       
                ans += lastList.get(i);
            }
            max = Math.max(max, ans);
        }

        System.out.println(max);
    }

    public static void cb(int[] a, int n, int start, int idx) {
        if (idx == K) {
            list.add(a.clone());
            return;
        }
        
        for (int i = start; i <= n; i++) {
            a[idx] = i;
            cb(a, n, i + 1, idx + 1);
        }
    }

    public static void check(int[] na, int[] a, int start, int idx, ArrayList<int[]> subList) {
        if (idx == 2) {
            subList.add(na.clone());
            return;
        }

        for (int i = start; i < K; i++) {
            na[idx] = a[i];
            check(na, a, i + 1, idx + 1, subList);
        }
    }
}
