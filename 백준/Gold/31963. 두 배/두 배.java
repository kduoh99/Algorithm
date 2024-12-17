import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] next = new int[N];
		for (int i = 1; i < N - 1; i++) {
			int tmp = arr[i];

			while (tmp <= arr[i + 1]) {
				tmp <<= 1;
				next[i]++;
			}

			if (next[i] > 0) {
				next[i]--;
			}
		}

		int[] prev = new int[N + 1];
		for (int i = 1; i < N; i++) {
			int tmp = arr[i];

			while (tmp < arr[i - 1]) {
				tmp <<= 1;
				prev[i]++;
			}

			if (next[i] < prev[i]) {
				prev[i + 1] += prev[i] - next[i];
			}
		}

		long count = 0;
		for (int r : prev) {
			count += r;
		}

		System.out.println(count - prev[N]);
		br.close();
	}
}
