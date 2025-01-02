import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int M;
	private static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		st = new StringTokenizer(br.readLine());

		int maxL = 0, totalL = 0;

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			maxL = Math.max(maxL, A[i]);
			totalL += A[i];
		}

		System.out.println(binarySearch(maxL, totalL));
		br.close();
	}

	private static int binarySearch(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int cnt = find(A, mid);

			if (cnt <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static int find(int[] A, int M) {
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
