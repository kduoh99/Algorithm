import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
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
			PriorityQueue<int[]> pq = new PriorityQueue<>(
				Comparator.comparingInt((int[] o) -> o[2])
					.thenComparing(o -> o[0])
					.thenComparing(o -> o[1])
			);

			boolean[][] visited = new boolean[N][N];
			Deque<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {startX, startY, 0});
			visited[startX][startY] = true;
			boolean flag = false;

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0], y = cur[1], dist = cur[2];

				if (arr[x][y] > 0 && arr[x][y] < shark) {
					pq.offer(new int[] {x, y, dist});
					flag = true;
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

			if (!flag) break;

			int[] target = pq.poll();
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
