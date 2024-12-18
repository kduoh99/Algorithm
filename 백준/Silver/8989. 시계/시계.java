import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 5;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String[] times = new String[SIZE];

			for (int j = 0; j < SIZE; j++) {
				times[j] = st.nextToken();
			}

			Arrays.sort(times, (a, b) -> {
				double angleA = calAngle(a);
				double angleB = calAngle(b);

				if (angleA != angleB) {
					return Double.compare(angleA, angleB);
				}
				return a.compareTo(b);
			});
			sb.append(times[2]).append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	private static double calAngle(String time) {
		String[] hm = time.split(":");
		int h = Integer.parseInt(hm[0]);
		int m = Integer.parseInt(hm[1]);
		double hAngle = (h % 12) * 30 + (m * 0.5);
		double mAngle = m * 6;
		double angle = Math.abs(hAngle - mAngle);
		return Math.min(angle, 360 - angle);
	}
}
