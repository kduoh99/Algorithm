import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] button = new boolean[10];

		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				int b = Integer.parseInt(st.nextToken());
				button[b] = true;
			}
		}

		if (N - 100 == 0) {
			System.out.println(0);
			return;
		}

		int ans = Math.abs(N - 100);

		for (int i = 0; i <= 999999; i++) {
			String C = String.valueOf(i);
			boolean flag = false;

			for (int j = 0; j < C.length(); j++) {
				if (button[C.charAt(j) - '0']) {
					flag = true;
					break;
				}
			}

			if (!flag) {
				int min = Math.abs(N - i) + C.length();
				ans = Math.min(ans, min);
			}
		}

		System.out.println(ans);
		br.close();
	}
}
