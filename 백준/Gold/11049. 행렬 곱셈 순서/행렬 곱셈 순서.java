import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] M = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M[i][0] = Integer.parseInt(st.nextToken());
			M[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N][N];
		for (int k = 1; k < N; k++) {
			for (int i = 0; i + k < N; i++) {
				dp[i][i + k] = Integer.MAX_VALUE;

				for (int j = i; j < i + k; j++) {
					dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + M[i][0] * M[j][1] * M[i + k][1]);
				}
			}
		}

		System.out.println(dp[0][N - 1]);
		br.close();
	}
}