import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};

	private static char[][] grid;
	private static boolean[][] visited;
	private static int H, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			grid = new char[H][W];
			visited = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				grid[i] = br.readLine().toCharArray();
			}

			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (grid[i][j] == '#' && !visited[i][j]) {
						bfs(i, j);
						count++;
					}
				}
			}
			sb.append(count).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new int[] {x, y});

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx >= 0 && nx < H && ny >= 0 && ny < W
					&& grid[nx][ny] == '#' && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
