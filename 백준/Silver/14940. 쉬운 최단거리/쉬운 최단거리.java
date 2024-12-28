import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[][] arr, dist;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		int startX = 0, startY = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(startX, startY);
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j])
					sb.append("-1 ");
				else
					sb.append(dist[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int startX, int startY) {
		dist = new int[n][m];
		visited = new boolean[n][m];
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX, startY, 0});

		while (!q.isEmpty()) {
			int[] cur = q.remove();
			int x = cur[0], y = cur[1], d = cur[2];

			if (visited[x][y]) continue;
			visited[x][y] = true;
			dist[x][y] = d;

			if (x - 1 >= 0 && arr[x - 1][y] == 1 && !visited[x - 1][y])
				q.offer(new int[] {x - 1, y, d + 1});
			if (x + 1 < n && arr[x + 1][y] == 1 && !visited[x + 1][y])
				q.offer(new int[] {x + 1, y, d + 1});
			if (y - 1 >= 0 && arr[x][y - 1] == 1 && !visited[x][y - 1])
				q.offer(new int[] {x, y - 1, d + 1});
			if (y + 1 < m && arr[x][y + 1] == 1 && !visited[x][y + 1])
				q.offer(new int[] {x, y + 1, d + 1});
		}
	}
}