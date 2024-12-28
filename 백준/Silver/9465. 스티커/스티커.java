import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] A = new int[2][N + 1];

			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int k = 1; k <= N; k++)
					A[j][k] = Integer.parseInt(st.nextToken());
			}

			int[][] dp = new int[2][N + 1];
			dp[0][1] = A[0][1];
			dp[1][1] = A[1][1];

			for (int j = 2; j <= N; j++) {
				dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + A[0][j];
				dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + A[1][j];
			}
			sb.append(Math.max(dp[0][N], dp[1][N])).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}