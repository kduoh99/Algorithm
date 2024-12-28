import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] A = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(A[i], Integer.MAX_VALUE);
			A[i][i] = 0;
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int isConnected = Integer.parseInt(st.nextToken());

				if (isConnected == 1)
					A[i][j] = 1;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (A[i][k] == 1 && A[k][j] == 1)
						A[i][j] = 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (A[i][j] == Integer.MAX_VALUE)
					sb.append("0 ");
				else
					sb.append(A[i][j]).append(" ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
