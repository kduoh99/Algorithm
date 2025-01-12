import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	private static final int INF = 100;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			for (int j = 0; j < N; j++) {
				if (i == j) {
					dist[i][j] = 0;
				} else if (str.charAt(j) == 'Y') {
					dist[i][j] = 1;
				} else {
					dist[i][j] = INF;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;

			for (int j = 0; j < N; j++) {
				if (i != j && dist[i][j] <= 2) {
					cnt++;
				}
 			}

			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);
		br.close();
	}
}
