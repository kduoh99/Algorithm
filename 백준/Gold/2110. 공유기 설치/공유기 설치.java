import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, C;
	private static int[] X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		X = new int[N];
		
		for (int i = 0; i < N; i++)
			X[i] = Integer.parseInt(br.readLine());

		Arrays.sort(X);
		int left = 1, right = X[N - 1] - X[0], result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (routers(mid)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(result);
		br.close();
	}

	private static boolean routers(int dist) {
		int cnt = 1;
		int last = X[0];

		for (int i = 1; i < N; i++) {
			if (X[i] - last >= dist) {
				cnt++;
				last = X[i];
			}
		}

		return cnt >= C;
	}
}
