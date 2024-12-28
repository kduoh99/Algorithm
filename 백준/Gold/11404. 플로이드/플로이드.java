import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = 10_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(A[i], INF);
			A[i][i] = 0;
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			A[a][b] = Math.min(A[a][b], c);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++)
					A[i][j] = Math.min(A[i][j], A[i][k] + A[k][j]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (A[i][j] == INF)
					A[i][j] = 0;
				sb.append(A[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
