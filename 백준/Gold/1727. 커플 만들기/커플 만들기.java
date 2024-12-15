import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arrN = new int[n];
		for (int i = 0; i < n; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int[] arrM = new int[m];
		for (int i = 0; i < m; i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arrN);
		Arrays.sort(arrM);

		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int v = Math.abs(arrN[i - 1] - arrM[j - 1]);
				if (i == j) {
					dp[i][j] = v + dp[i - 1][j - 1];
				} else if (i > j) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1] + v);
				} else {
					dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + v);
				}
			}
		}

		System.out.println(dp[n][m]);
		br.close();
	}
}
