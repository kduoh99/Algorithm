import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		A = new int[N];
		int max = 0;

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, A[i]);
		}

		System.out.println(binarySearch(0, max));
		br.close();
	}

	private static int binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (A[i] > mid) sum += A[i] - mid;
			}

			if (sum >= M) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return right;
	}
}
