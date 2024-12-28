import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[][] A = new long[N][N];
		long[] ans = new long[N];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			// 비율 간소화
			long gcd = gcd(p, q);
			A[a][b] = p / gcd;
			A[b][a] = q / gcd;
		}

		boolean flag = false;
		while (!flag) {
			flag = true;

			for (int i = 0; i < N; i++) {
				long lcm = 1;

				for (int j = 0; j < N; j++) {
					if (A[i][j] > 0) lcm = lcm(lcm, A[i][j]);
				}

				if (ans[i] != lcm) {
					flag = false;
					ans[i] = lcm;

					for (int j = 0; j < N; j++) {
						if (A[i][j] > 0) {
							A[j][i] *= lcm / A[i][j];
							A[i][j] = lcm;
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (long i : ans)
			sb.append(i).append(' ');

		System.out.println(sb);
		br.close();
	}

	private static long gcd(long a, long b) {
		while (b != 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

	private static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}
}
