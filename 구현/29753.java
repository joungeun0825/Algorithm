import java.util.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        BigDecimal a = new BigDecimal(st.nextToken());

        BigDecimal[][] arr = new BigDecimal[N][2];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            BigDecimal c = new BigDecimal(st.nextToken());
            String g = st.nextToken();
            arr[i][0] = c;
            
            switch (g) {
                case "A+":
                    arr[i][1] = new BigDecimal("4.50");
                    break;
                case "A0":
                    arr[i][1] = new BigDecimal("4.00");
                    break;
                case "B+":
                    arr[i][1] = new BigDecimal("3.50");
                    break;
                case "B0":
                    arr[i][1] = new BigDecimal("3.00");
                    break;
                case "C+":
                    arr[i][1] = new BigDecimal("2.50");
                    break;
                case "C0":
                    arr[i][1] = new BigDecimal("2.00");
                    break;
                case "D+":
                    arr[i][1] = new BigDecimal("1.50");
                    break;
                case "D0":
                    arr[i][1] = new BigDecimal("1.00");
                    break;
                case "F":
                    arr[i][1] = new BigDecimal("0.00");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid grade: " + g);
            }
        }

        st = new StringTokenizer(br.readLine());
        BigDecimal L = new BigDecimal(st.nextToken());
        BigDecimal grade = new BigDecimal("4.50");
        BigDecimal result = BigDecimal.ZERO; 
        boolean found = false;

        while (grade.compareTo(BigDecimal.ZERO) >= 0) {
            BigDecimal sum = BigDecimal.ZERO;
            BigDecimal sum2 = BigDecimal.ZERO;

            for (int i = 0; i < N - 1; i++) {
                sum = sum.add(arr[i][0].multiply(arr[i][1]));
                sum2 = sum2.add(arr[i][0]);
            }

            sum = sum.add(L.multiply(grade));
            sum2 = sum2.add(L);

            BigDecimal average = sum.divide(sum2, 2, RoundingMode.DOWN);

            if (average.compareTo(a) > 0) {
                result = grade;
                found = true;
            }

            grade = grade.subtract(new BigDecimal("0.50"));
        }

        if (!found) {
            System.out.println("impossible");
        } else {
            if (result.compareTo(new BigDecimal("4.50")) == 0) {
                System.out.println("A+");
            } else if (result.compareTo(new BigDecimal("4.00")) == 0) {
                System.out.println("A0");
            } else if (result.compareTo(new BigDecimal("3.50")) == 0) {
                System.out.println("B+");
            } else if (result.compareTo(new BigDecimal("3.00")) == 0) {
                System.out.println("B0");
            } else if (result.compareTo(new BigDecimal("2.50")) == 0) {
                System.out.println("C+");
            } else if (result.compareTo(new BigDecimal("2.00")) == 0) {
                System.out.println("C0");
            } else if (result.compareTo(new BigDecimal("1.50")) == 0) {
                System.out.println("D+");
            } else if (result.compareTo(new BigDecimal("1.00")) == 0) {
                System.out.println("D0");
            } else if (result.compareTo(BigDecimal.ZERO) == 0) {
                System.out.println("F");
            }
        }
    }
}
