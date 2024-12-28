import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] A, lisA;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		lisA = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		lis();

		int max = 0, maxIdx = 0;
		for (int i = 0; i < N; i++) {
			if (max < lisA[i]) {
				max = lisA[i];
				maxIdx = i;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(max).append('\n');

		int len = max;
		int cur = maxIdx;
		int[] result = new int[len];
		result[--len] = A[cur];

		for (int i = cur - 1; i >= 0; i--) {
			if (A[i] < A[cur] && lisA[i] == lisA[cur] - 1) {
				result[--len] = A[i];
				cur = i;
			}
		}

		for (int num : result)
			sb.append(num).append(' ');

		System.out.println(sb);
		br.close();
	}
	private static void lis() {
		for (int i = 0; i < N; i++) {
			lisA[i] = 1;

			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && lisA[i] < lisA[j] + 1)
					lisA[i] = lisA[j] + 1;
			}
		}
	}
}
