import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = { 0, 1, 0, -1 };
	private static final int[] dy = { 1, 0, -1, 0 };
	private static boolean[][] visited;
	private static int[][] A;
	private static int N, M, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N][M];
		A = new int[N][M];
		int startX = 0, startY = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j);

				if (A[i][j] == 'I') {
					startX = i;
					startY = j;
				}
			}
		}

		bfs(startX, startY);
		System.out.println(cnt != 0 ? cnt : "TT");
		br.close();
	}

	private static void bfs(int i, int j) {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int k = 0; k < 4; k++) {
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				
				if (x >= 0 && x < N && y >= 0 && y < M) {
					if (A[x][y] != 'X' && !visited[x][y]) {
						if (A[x][y] == 'P')
							cnt++;

						visited[x][y] = true;
						A[x][y] = A[cur[0]][cur[1]] + 1;
						q.offer(new int[] { x, y });
					}
				}
			}
		}

	}
}
