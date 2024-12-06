import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {-1, 0, 0, 1};
	private static final int[] dy = {0, -1, 1, 0};
	private static int[][] arr;
	private static int N, shark = 2, eat = 0, time = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int startX = 0, startY = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 9) {
					startX = i;
					startY = j;
					arr[i][j] = 0;
				}
			}
		}

		System.out.println(bfs(startX, startY));
		br.close();
	}

	private static int bfs(int startX, int startY) {
		while (true) {
			Deque<int[]> q = new ArrayDeque<>();
			boolean[][] visited = new boolean[N][N];
			q.offer(new int[] {startX, startY, 0});
			visited[startX][startY] = true;

			int[] target = null;

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1], dist = cur[2];

				if (arr[x][y] > 0 && arr[x][y] < shark) {
					if (target == null || dist < target[2] ||
						(dist == target[2] && (x < target[0] || (x == target[0] && y < target[1])))) {
						target = new int[] {x, y, dist};
					}
				}

				for (int k = 0; k < 4; k++) {
					int nx = x + dx[k];
					int ny = y + dy[k];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] <= shark) {
						q.offer(new int[] {nx, ny, dist + 1});
						visited[nx][ny] = true;
					}
				}
			}

			if (target == null) break;

			startX = target[0];
			startY = target[1];
			time += target[2];
			arr[startX][startY] = 0;

			eat++;
			if (shark == eat) {
				shark++;
				eat = 0;
			}
		}

		return time;
	}
}
