import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int up = 1, front = 2, right = 3;
		long sum = 1;

		for (int row = 0; row < R; row++) {
			if (row % 2 == 0) {

				for (int col = 1; col < C; col++) {
					int tmp = up;
					up = 7 - right;
					right = tmp;
					sum += up;
				}
			} else {
				for (int col = C - 2; col >= 0; col--) {
					int tmp = up;
					up = right;
					right = 7 - tmp;
					sum += up;
				}
			}

			if (row < R - 1) {
				int tmp = up;
				up = 7 - front;
				front = tmp;
				sum += up;
			}
		}

		System.out.println(sum);
		br.close();
	}
}
