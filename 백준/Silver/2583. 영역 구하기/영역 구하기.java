import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	
	private static int M, N;
	private static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[M][N];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					board[i][j] = 1;
				}
			}
		}

		ArrayList<Integer> area = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {
					area.add(dfs(i, j));
				}
			}
		}

		Collections.sort(area);
		StringBuilder sb = new StringBuilder();
		sb.append(area.size()).append('\n');

		for (int i : area) {
			sb.append(i).append(' ');
		}

		System.out.println(sb);
		br.close();
	}

	private static int dfs(int x, int y) {
		board[x][y] = 1;
		int area = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] == 0) {
				area += dfs(nx, ny);
			}
		}
		return area;
	}
}