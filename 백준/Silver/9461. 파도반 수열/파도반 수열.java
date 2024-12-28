import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static long[] dp = new long[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(P(N)).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
	
	private static long P(int N) {
		dp[1] = dp[2] = dp[3] = 1;

		for (int i = 4; i <= N; i++)
			dp[i] = dp[i - 2] + dp[i - 3];

		return dp[N];
	}
}