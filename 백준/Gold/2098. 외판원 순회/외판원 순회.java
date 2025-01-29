import java.io.*;
import java.util.*;

public class Main {
	private static final int INF = Integer.MAX_VALUE / 2;
	private static int N;
	private static int[][] W, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		dp = new int[N][1 << N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], -1);

			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 1));
		br.close();
	}

	private static int dfs(int cur, int visited) {
		// 모든 도시 방문 완료
		if (visited == (1 << N) - 1) {
			// 출발 도시로 돌아가는 길이 존재하지 않으면 INF
			return W[cur][0] == 0 ? INF : W[cur][0];
		}

		// 이미 방문한 도시
		if (dp[cur][visited] != -1) {
			return dp[cur][visited];
		}
		dp[cur][visited] = INF;

		// 방문하지 않은 도시 탐색
		for (int i = 1; i < N; i++) {
			// 방문하지 않았고, 경로가 존재하는 경우
			if ((visited & (1 << i)) == 0 && W[cur][i] != 0) {
				int next = visited | (1 << i);
				dp[cur][visited] = Math.min(dp[cur][visited], dfs(i, next) + W[cur][i]);
			}
		}

		return dp[cur][visited];
	}
}
