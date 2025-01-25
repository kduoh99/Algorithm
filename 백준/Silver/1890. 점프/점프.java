import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				board[i][j] = Integer.parseInt(st.nextToken());
		}

		long[][] dp = new long[N][N];
		dp[0][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int jump = board[i][j];
				if (jump == 0) break;
				if (i + jump < N) dp[i + jump][j] += dp[i][j];
				if (j + jump < N) dp[i][j + jump] += dp[i][j];
			}
		}

		System.out.println(dp[N - 1][N - 1]);
		br.close();
	}
}
