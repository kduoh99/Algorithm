import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(st.nextToken());
				arr[i][j] = val;
				max = Math.max(max, val);
				min = Math.min(min, val);
			}
		}

		int time = Integer.MAX_VALUE;
		int height = 0;

		for (int k = max; k >= min; k--) {
			int T = 0;
			int INV = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] > k) {
						INV += arr[i][j] - k;
						T += 2 * (arr[i][j] - k);
					}
					else if (arr[i][j] < k) {
						INV -= k - arr[i][j];
						T += k - arr[i][j];
					}
				}
			}
			if (INV >= 0 && time > T) {
				height = k;
				time = T;
			}
		}
		
		System.out.println(time + " " + height);
		br.close();
	}
}
