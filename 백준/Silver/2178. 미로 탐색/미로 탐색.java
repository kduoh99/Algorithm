import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};

	private static int[][] arr;
	private static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();

			for (int j = 0; j < M; j++) {
				arr[i][j] = ch[j] - '0';
			}
		}

		bfs();
		System.out.println(arr[N - 1][M - 1]);
		br.close();
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1) {
					q.offer(new int[] {nx, ny});
					arr[nx][ny] = arr[x][y] + 1;
				}
			}
		}
	}
}
