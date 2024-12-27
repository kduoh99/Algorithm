import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[][] dp = new int[30][30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(comb(M, N)).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static int comb(int N, int M) {
		if (dp[N][M] != 0) return dp[N][M];
		if (N == M || M == 0) return dp[N][M] = 1;

		return dp[N][M] = comb(N - 1, M - 1) + comb(N - 1, M);
	}
}
