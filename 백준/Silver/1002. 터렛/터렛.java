import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int count;

		while (T-- > 0) {
			int[] xyr = new int[6];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 6; i++) {
				xyr[i] = Integer.parseInt(st.nextToken());
			}

			int dist = (int)(Math.pow(xyr[3] - xyr[0], 2) + Math.pow(xyr[4] - xyr[1], 2));

			if (xyr[0] == xyr[3] && xyr[1] == xyr[4] && xyr[2] == xyr[5]) {
				count = -1;
			} else if ((dist > Math.pow(xyr[2] + xyr[5], 2)) || dist < Math.pow(xyr[5] - xyr[2], 2)) {
				count = 0;
			} else if ((dist == Math.pow(xyr[2] + xyr[5], 2)) || dist == Math.pow(xyr[5] - xyr[2], 2)) {
				count = 1;
			} else {
				count = 2;
			}

			sb.append(count).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
