import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {1, 0, -1, 0};

	private static int N, L, R;
	private static int[][] A;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++)
				A[r][c] = Integer.parseInt(st.nextToken());
		}

		int days = 0;
		while (true) {
			boolean flag = false;
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (bfs(r, c)) {
						flag = true;
					}
				}
			}
			if (!flag)
				break;
			days++;
		}

		System.out.println(days);
		br.close();
	}

	private static boolean bfs(int x, int y) {
		if (visited[x][y]) return false;
		Deque<int[]> q = new ArrayDeque<>();
		List<int[]> countries = new ArrayList<>();
		q.offer(new int[]{x, y});
		countries.add(new int[]{x, y});
		visited[x][y] = true;

		int sum = A[x][y];
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cx;
				int ny = dy[i] + cy;

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]
					&& Math.abs(A[cx][cy] - A[nx][ny]) >= L && Math.abs(A[cx][cy] - A[nx][ny]) <= R) {
					q.offer(new int[]{nx, ny});
					countries.add(new int[]{nx, ny});
					visited[nx][ny] = true;
					sum += A[nx][ny];
				}
			}
		}

		if (countries.size() > 1) {
			int avg = sum / countries.size();

			for (int[] country : countries)
				A[country[0]][country[1]] = avg;
			return true;
		}
		return false;
	}
}
