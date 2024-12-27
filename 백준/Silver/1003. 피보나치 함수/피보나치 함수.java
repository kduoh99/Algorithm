import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int zero, one, zero_one;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			fib(N);
			sb.append(zero).append(' ').append(one).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void fib(int N) {
		zero = 1;
		one = 0;
		zero_one = zero + one;

		for (int i = 0; i < N; i++) {
			zero = one;
			one = zero_one;
			zero_one = zero + one;
		}
	}
}
