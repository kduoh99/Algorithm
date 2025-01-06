import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};

	private static int R, C, startX, startY;
	private static char[][] graph;
	private static boolean[][] visited;
	private static Deque<int[]> fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new char[R][C];
		visited = new boolean[R][C];
		fire = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		search();
		int result = bfs(startX, startY);
		System.out.println(result == -1 ? "IMPOSSIBLE" : result);
		br.close();
	}

	private static void search() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (graph[i][j] == 'J') {
					startX = i;
					startY = j;
				} else if (graph[i][j] == 'F') {
					fire.offer(new int[] {i, j});
				}
			}
		}
	}

	private static void fireSpread() {
		int size = fire.size();

		for (int i = 0; i < size; i++) {
			int[] cur = fire.poll();
			int x = cur[0], y = cur[1];

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (nx >= 0 && nx < R && ny >= 0 && ny < C && graph[nx][ny] == '.') {
					graph[nx][ny] = 'F';
					fire.offer(new int[] {nx, ny});
				}
			}
		}
	}

	private static int bfs(int startX, int startY) {
		Deque<int[]> q = new ArrayDeque<>();
		visited[startX][startY] = true;
		q.offer(new int[] {startX, startY, 0});

		while (!q.isEmpty()) {
			fireSpread();
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1], time = cur[2];

				if (x == 0 || x == R - 1 || y == 0 || y == C - 1) {
					return time + 1;
				}

				for (int j = 0; j < 4; j++) {
					int nx = cur[0] + dx[j];
					int ny = cur[1] + dy[j];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && graph[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, time + 1});
					}
				}
			}
		}

		return -1;
	}
}
