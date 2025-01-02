import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int K;
	private static int[] X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		X = new int[N];
		int left = Integer.MAX_VALUE, right = 0;

		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
			left = Math.min(left, X[i]);
			right += X[i];
		}

		System.out.println(binarySearch(left, right));
		br.close();
	}

	private static int binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int sum = 0, count = 0;

			for (int x : X) {
				sum += x;
				if (sum >= mid) {
					sum = 0;
					count++;
				}
			}

			if (count >= K) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return right;
	}
}
