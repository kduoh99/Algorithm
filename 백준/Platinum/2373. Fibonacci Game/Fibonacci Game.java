import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 32;
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp = new int[SIZE];
		int N = Integer.parseInt(br.readLine());
		int copy = N;

		while (true) {
			int tmp = N;

			for (int i = 3; i < SIZE; i++) {
				if (tmp < fib(i)) {
					tmp = fib(i - 1);
					break;
				}
			}

			if (tmp == N) break;
			N -= tmp;
		}

		System.out.println(N == copy ? -1 : N);
		br.close();
	}

	private static int fib(int n) {
		if (n <= 1) {
			return n;
		} else if (dp[n] != 0) {
			return dp[n];
		} else {
			return dp[n] = fib(n - 2) + fib(n - 1);
		}
	}
}
