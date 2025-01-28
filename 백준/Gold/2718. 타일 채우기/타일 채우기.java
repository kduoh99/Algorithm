import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		int[] dp = new int[22];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 5;
		dp[3] = 11;

		for (int i = 4; i <= 21; i++) {
			dp[i] = dp[i - 1] + 5 * dp[i - 2] + dp[i - 3] - dp[i - 4];
		}

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
