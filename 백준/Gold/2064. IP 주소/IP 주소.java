import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int PARTS = 4;
	private static int n;
	private static int[][] ips;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		ips = new int[n][PARTS];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), ".");

			for (int j = 0; j < PARTS; j++) {
				ips[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		calNetInfo();
		br.close();
	}

	private static void calNetInfo() {
		StringBuilder addr = new StringBuilder();
		StringBuilder mask = new StringBuilder();
		boolean flag = false;

		for (int i = 0; i < PARTS; i++) {
			int min = ips[0][i];
			int max = ips[0][i];

			for (int j = 1; j < n; j++) {
				min &= ips[j][i];
				max |= ips[j][i];
			}

			addr.append(flag ? 0 : min);
			mask.append(flag ? 0 : (255 - (max - min)));

			if (i < PARTS - 1) {
				addr.append('.');
				mask.append('.');
			}

			if (min != max) {
				flag = true;
			}
		}

		System.out.println(addr);
		System.out.println(mask);
	}
}
