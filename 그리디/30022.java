import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static long[] products;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		products = new long[N];
		long total = 0;
		for (int i = 0; i < products.length; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			total += a;
			products[i] = b - a;
		}
        System.out.println(total);

		Arrays.sort(products);
		for (int i = 0; i < B; i++) {
            System.out.println(products[i]);
			total += products[i];
		}

		System.out.println(total);
	}
}
