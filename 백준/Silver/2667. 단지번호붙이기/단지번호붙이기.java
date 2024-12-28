import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Main {
	private static final ArrayList<Integer> result = new ArrayList<>();
	private static final StringBuilder sb = new StringBuilder();

	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();

			for (int j = 0; j < N; j++)
				arr[i][j] = line.charAt(j) - '0';
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visited[i][j])
					bfs(i, j);
			}
		}

		Collections.sort(result);
		sb.append(result.size()).append('\n');
		for (int v : result)
			sb.append(v).append('\n');

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int cnt = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}
		result.add(cnt);
	}
}
