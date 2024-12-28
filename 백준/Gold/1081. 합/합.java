import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 10;
	private static int digit = 1;
	private static long sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());

		while (L <= U) {
			while (U % 10 != 9 && L <= U) {
				updateSum(U);
				U--;
			}

			while (L % 10 != 0 && L <= U) {
				updateSum(L);
				L++;
			}

			if (L > U) break;
			L /= 10;
			U /= 10;

			for (int i = 0; i < 10; i++)
				sum += (long) (U - L + 1) * digit * i;

			digit *= 10;
		}

		System.out.println(sum);
		br.close();
	}

	private static void updateSum(int num) {
		while (num > 0) {
			sum += (long) (num % SIZE) * digit;
			num /= 10;
		}
	}
}
