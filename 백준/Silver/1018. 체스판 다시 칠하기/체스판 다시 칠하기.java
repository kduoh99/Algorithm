import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static boolean[][] board;
	private static int min = 64;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();

			for (int j = 0; j < M; j++) {
				board[i][j] = ch[j] == 'W';
			}
		}

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				cal(i, j);
			}
		}

		System.out.println(min);
		br.close();
	}

	private static void cal(int x, int y) {
		int count = 0;
		boolean WB = board[x][y];

		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if (board[i][j] != WB) count++;
				WB = !WB;
			}
			WB = !WB;
		}
		count = Math.min(count, 64 - count);
		min = Math.min(min, count);
	}
}
