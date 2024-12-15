import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 80;
	private static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new long[SIZE];
		long N = Long.parseLong(br.readLine());

		while (true) {
			long tmp = N;

			for (int i = 3; i < SIZE; i++) {
				if (tmp < fib(i)) {
					tmp = fib(i - 1);
					break;
				}
			}

			if (tmp == N) break;
			N -= tmp;
		}

		System.out.println(N);
		br.close();
	}

	private static long fib(int n) {
		if (n <= 1) {
			return n;
		} else if (dp[n] != 0) {
			return dp[n];
		} else {
			return dp[n] = fib(n - 2) + fib(n - 1);
		}
	}
}
