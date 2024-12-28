import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][N];
		dp[0][0] = arr[0][0];

		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				// 맨 왼쪽 경로
				if (j == 0)
					dp[i][j] = dp[i - 1][j] + arr[i][j];
					// 맨 오른쪽 경로
				else if (j == i)
					dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
					// 중간 경로
				else
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			}
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, dp[N - 1][i]);

		System.out.println(ans);
		br.close();

	}
}
