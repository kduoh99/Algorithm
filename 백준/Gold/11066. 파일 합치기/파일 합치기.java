import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[] A = new int[K + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				A[i] = A[i - 1] + tmp;
			}

			int[][] dp = new int[K + 1][K + 1];

			for (int n = 1; n < K; n++) {
				for (int start = 1; start + n <= K; start++) {
					int end = start + n;
					dp[start][end] = Integer.MAX_VALUE;

					for (int mid = start; mid < end; mid++) {
						dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + A[end] - A[start - 1]);
					}
				}
			}

			sb.append(dp[1][K]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}