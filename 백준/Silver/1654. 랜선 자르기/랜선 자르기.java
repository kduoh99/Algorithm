import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[K];

		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);
		long max = arr[K - 1];
		long min = 1, mid;

		while (min <= max) {
			mid = (max + min) / 2;
			long cnt = 0;

			for (int i = 0; i < K; i++)
				cnt += arr[i] / mid;

			if (cnt < N) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		System.out.println(max);
		br.close();
	}
}
