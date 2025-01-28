import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0) break;

			int max = 0;
			int[][] dp = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < M; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());

					if (i > 0 && j > 0 && dp[i][j] > 0) {
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					}
					max = Math.max(max, dp[i][j]);
				}
			}

			sb.append(max).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
