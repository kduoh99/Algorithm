import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static final int SIZE = 27;
	private static final int INF = 1000;
	private static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dist = new int[SIZE][SIZE];
		for (int i = 1; i < SIZE; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String[] str = br.readLine().split(" ");
			int from = str[0].charAt(0) - 'a' + 1;
			int to = str[2].charAt(0) - 'a' + 1;
			dist[from][to] = 1;
		}

		floyd();
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());
		
		while (m-- > 0) {
			String[] str = br.readLine().split(" ");
			int from = str[0].charAt(0) - 'a' + 1;
			int to = str[2].charAt(0) - 'a' + 1;
			sb.append(dist[from][to] == INF ? "F" : "T").append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void floyd() {
		for (int k = 1; k < SIZE; k++) {
			for (int i = 1; i < SIZE; i++) {
				for (int j = 1; j < SIZE; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
 		}
	}
}
