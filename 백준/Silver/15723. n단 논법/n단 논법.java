import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 26;
	private static boolean[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dist = new boolean[SIZE][SIZE];
		int n = Integer.parseInt(br.readLine());

		while (n-- > 0) {
			String[] str = br.readLine().split(" ");
			int from = str[0].charAt(0) - 'a';
			int to = str[2].charAt(0) - 'a';
			dist[from][to] = true;
		}

		floyd();
		StringBuilder sb = new StringBuilder();
		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
			String[] str = br.readLine().split(" ");
			int from = str[0].charAt(0) - 'a';
			int to = str[2].charAt(0) - 'a';
			sb.append(dist[from][to] ? "T" : "F").append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static void floyd() {
		for (int k = 0; k < SIZE; k++) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (dist[i][k] && dist[k][j]) {
						dist[i][j] = true;
					}
				}
			}
 		}
	}
}
