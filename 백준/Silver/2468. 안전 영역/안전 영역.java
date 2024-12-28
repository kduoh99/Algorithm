import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0};
	
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer st;
		int maxH = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}

		int ans = 0;
		for (int h = 0; h <= maxH; h++) {
			visited = new boolean[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						cnt++;
						dfs(i, j, h);
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		br.close();
	}

	private static void dfs(int x, int y, int h) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx < 0 || ny < 0 || nx >= N || ny >= N
				|| visited[nx][ny] || map[nx][ny] <= h) {
				continue;
			}
			dfs(nx, ny, h);
		}
	}
}
