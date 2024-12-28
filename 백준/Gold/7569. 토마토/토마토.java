import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final Deque<int[]> q = new ArrayDeque<>();
	private static int N, M, H;
	private static int[][][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());

					if (arr[i][j][k] == 1)
						q.offer(new int[] { i, j, k });
				}
			}
		}

		bfs();
		br.close();
	}

	private static void bfs() {
		int[] dx = { -1, 0, 1, 0, 0, 0 };
		int[] dy = { 0, 1, 0, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };
		int days = -1;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int z = cur[2];

				for (int j = 0; j < 6; j++) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					int nz = z + dz[j];

					if (nx >= 0 && nx < H && ny >= 0 && ny < N && nz >= 0 && nz < M && arr[nx][ny][nz] == 0) {
						q.offer(new int[] { nx, ny, nz });
						arr[nx][ny][nz] = 1;
					}
				}
			}
			days++;
		}

		System.out.println(check() ? days : "-1");
	}

	private static boolean check() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 0)
						return false;
				}
			}
		}
		return true;
	}
}