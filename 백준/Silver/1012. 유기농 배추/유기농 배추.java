import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] visited, TF;
	private static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			TF = new boolean[M][N];
			visited = new boolean[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				TF[x][y] = true;
			}

			int ans = 0;
			for (int x = 0; x < M; x++) {
				for (int y = 0; y < N; y++) {
					if (TF[x][y] && !visited[x][y]) {
						dfs(x, y);
						ans++;
					}
				}
			}
			sb.append(ans).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int x, int y) {
		if (x < 0 || x >= M || y < 0 || y >= N || visited[x][y] || !TF[x][y]) return;
		visited[x][y] = true;

		dfs(x - 1, y);
		dfs(x + 1, y);
		dfs(x, y - 1);
		dfs(x, y + 1);
	}
}
