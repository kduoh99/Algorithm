import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
	private static final int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) break;
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			sb.append(cnt).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (nx >= 0 && ny >= 0 && nx < h && ny < w
				&& !visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}
}