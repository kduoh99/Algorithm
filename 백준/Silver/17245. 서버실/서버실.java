import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[][] map;
	private static long total;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		total = 0L;
		int max = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
				max = Math.max(max, map[i][j]);
			}
		}

		System.out.println(binarySearch(0, max));
		br.close();
	}

	private static int binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			long count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count += Math.min(mid, map[i][j]);
				}
			}

			if (count * 2 >= total) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}
