import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int carsLen = Integer.parseInt(st.nextToken());
        int quests = Integer.parseInt(st.nextToken());
        
        int[] cars = new int[carsLen];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<carsLen; i++){
            cars[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cars);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<quests; i++){
            int quest = Integer.parseInt(br.readLine().trim());
            int idx = binarySearch(cars, quest);
            
            if(idx == 0 || idx == carsLen - 1 || idx == -1) {
                sb.append("0\n");
            } else {
                int result = (idx) * (carsLen - 1 - idx);
                sb.append(result).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // 존재하지 않음
    }
}
