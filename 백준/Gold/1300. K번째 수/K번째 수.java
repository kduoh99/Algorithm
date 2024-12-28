import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int start = 1, end = K;

		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 0;

			for (int i = 1; i <= N; i++)
				cnt += Math.min(mid / i, N);

			if (cnt < K) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		System.out.println(start);
		br.close();
	}
}
