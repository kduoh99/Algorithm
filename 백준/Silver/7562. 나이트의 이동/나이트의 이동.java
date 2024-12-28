import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	private static int I, x1, y1;
	private static int[][] board;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			I = Integer.parseInt(br.readLine());
			board = new int[I][I];
			visited = new boolean[I][I];

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			bfs();
			sb.append(board[x2][y2]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void bfs() {
		Deque<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x1, y1});
		visited[x1][y1] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 8; i++) {
				int nx = dx[i] + cx;
				int ny = dy[i] + cy;

				if (nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]) {
					q.offer(new int[]{nx, ny});
					board[nx][ny] = board[cx][cy] + 1;
					visited[nx][ny] = true;
				}
			}
		}
	}
}