import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] arr = new int[N + 1];
			int[] sum = new int[N + 1];
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] += sum[i - 1] + arr[i];
			}

			if (N == M) {
				sb.append(sum[N] < K ? 1 : 0).append('\n');
				continue;
			}

			int count = 0;
			for (int i = 1; i <= N; i++) {
				if (i < M) {
					if (sum[i] + sum[N] - sum[N - M + i] < K) {
						count++;
					}
				} else {
					if (sum[i] - sum[i - M] < K) {
						count++;
					}
				}
			}

			sb.append(count).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}
