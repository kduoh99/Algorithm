import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int recCnt = 0, dpCnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		recCnt = fib(n);
		System.out.println(recCnt + " " + dpCnt);
		br.close();
	}

	private static int fib(int n) {
		int[] dp = new int[n + 1];
		dp[1] = dp[2] = 1;

		for (int i = 3; i <= n; i++) {
			dpCnt++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
