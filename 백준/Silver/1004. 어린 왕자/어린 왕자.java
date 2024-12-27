import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			int N = Integer.parseInt(br.readLine());
			int cnt = 0;

			boolean[] startIn = new boolean[N];
			boolean[] endIn = new boolean[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int circleX = Integer.parseInt(st.nextToken());
				int circleY = Integer.parseInt(st.nextToken());
				int radius = Integer.parseInt(st.nextToken());

				startIn[j] = isIn(startX, startY, circleX, circleY, radius);
				endIn[j] = isIn(endX, endY, circleX, circleY, radius);

				if (startIn[j] && endIn[j])
					cnt -= 2;
			}

			for (int j = 0; j < N; j++) {
				if (startIn[j]) cnt++;
				if (endIn[j]) cnt++;
			}

			sb.append(cnt).append('\n');
		}

		System.out.print(sb);
		br.close();
	}

	private static boolean isIn(int px, int py, int cx, int cy, int radius) {
		return (Math.pow(cx - px, 2) + Math.pow(cy - py, 2)) <= Math.pow(radius, 2);
	}
}
