import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());

		int maxL = 0, totalL = 0;

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			maxL = Math.max(maxL, A[i]);
			totalL += A[i];
		}

		int left = maxL, right = totalL, result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = find(A, mid);

			if (cnt <= M) {
				result = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(result);
		br.close();
	}

	static int find(int[] A, int M) {
		int cnt = 1, sum = 0;

		for (int lesson : A) {
			sum += lesson;

			if (sum > M) {
				cnt++;
				sum = lesson;
			}
		}
		return cnt;
	}
}