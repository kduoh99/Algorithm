import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static int W = 0, B = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		partition(0, 0, N);
		sb.append(W).append('\n').append(B);
		System.out.println(sb);
		br.close();
	}

	private static void partition(int r, int c, int size) {
		if (check(r, c, size)) {
			if (arr[r][c] == 0) {
				W++;
			} else {
				B++;
			}
			return;
		}

		size /= 2;
		partition(r, c, size);
		partition(r, c + size, size);
		partition(r + size, c, size);
		partition(r + size, c + size, size);
	}

	private static boolean check(int r, int c, int size) {
		int color = arr[r][c];

		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (arr[i][j] != color)
					return false;
			}
		}
		return true;
	}
}