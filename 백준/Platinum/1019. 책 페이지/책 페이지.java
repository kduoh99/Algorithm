import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 10;
	private static int digit = 1;
	private static int[] counter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		counter = new int[SIZE];
		StringBuilder sb = new StringBuilder();
		int start = 1;

		while (start <= N) {
			while (N % 10 != 9 && start <= N) {
				update(N);
				N--;
			}

			if (N < start) break;

			while (start % 10 != 0 && start <= N) {
				update(start);
				start++;
			}

			start /= 10;
			N /= 10;

			for (int i = 0; i < 10; i++)
				counter[i] += (N - start + 1) * digit;

			digit *= 10;
		}

		for (int i : counter)
			sb.append(i).append(' ');

		System.out.println(sb);
		br.close();
	}

	private static void update(int num) {
		while (num > 0) {
			counter[num % 10] += digit;
			num /= 10;
		}
	}
}
