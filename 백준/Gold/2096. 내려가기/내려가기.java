import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] max, min;
	private static int a, b, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		max = new int[2][3];
		min = new int[2][3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int j = 0; j < 3; j++) {
			int val = Integer.parseInt(st.nextToken());
			max[0][j] = min[0][j] = val;
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			updateScores();
			for (int j = 0; j < 3; j++) {
				max[0][j] = max[1][j];
				min[0][j] = min[1][j];
			}
		}

		int maxScore = Math.max(Math.max(max[0][0], max[0][1]), max[0][2]);
		int minScore = Math.min(Math.min(min[0][0], min[0][1]), min[0][2]);

		StringBuilder sb = new StringBuilder();
		sb.append(maxScore).append('\n').append(minScore);
		System.out.println(sb);
		br.close();
	}

	private static void updateScores() {
		max[1][0] = Math.max(max[0][0], max[0][1]) + a;
		max[1][1] = Math.max(Math.max(max[0][0], max[0][1]), max[0][2]) + b;
		max[1][2] = Math.max(max[0][1], max[0][2]) + c;

		min[1][0] = Math.min(min[0][0], min[0][1]) + a;
		min[1][1] = Math.min(Math.min(min[0][0], min[0][1]), min[0][2]) + b;
		min[1][2] = Math.min(min[0][1], min[0][2]) + c;
	}
}
