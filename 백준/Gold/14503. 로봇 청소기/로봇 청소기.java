import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int[] dr = {-1, 0, 1, 0};
	private static final int[] dc = {0, 1, 0, -1};
	
	private static int[][] room;
	private static int r, c, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		room = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++)
				room[i][j] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		while (true) {
			if (room[r][c] == 0) {
				room[r][c] = 2;
				cnt++;
			}
			if (!move()) break;
		}
		
		System.out.println(cnt);
		br.close();
	}

	private static void turnLeft() {
		d = (d + 3) % 4;
	}

	private static boolean move() {
		for (int i = 0; i < 4; i++) {
			turnLeft();
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (room[nr][nc] == 0) {
				r = nr;
				c = nc;
				return true;
			}
		}

		int back = (d + 2) % 4;
		int nr = r + dr[back];
		int nc = c + dc[back];

		if (room[nr][nc] != 1) {
			r = nr;
			c = nc;
			return true;
		}

		return false;
	}
}
