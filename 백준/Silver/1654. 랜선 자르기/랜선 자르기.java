import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int K, N;
	private static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[K];

		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		System.out.println(binarySearch(1, arr[K - 1]));
		br.close();
	}

	private static long binarySearch(long left, long right) {
		while (left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			for (int i = 0; i < K; i++)
				cnt += arr[i] / mid;

			if (cnt >= N) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return right;
	}
}
