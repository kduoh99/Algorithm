import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer> lis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		lis = new ArrayList<>();
		lis.add(A[0]);

		for (int i = 1; i < N; i++) {
			if (lis.get(lis.size() - 1) < A[i]) {
				lis.add(A[i]);
			} else {
				binarySearch(A[i]);
			}
		}

		System.out.println(lis.size());
		br.close();
	}

	private static void binarySearch(int val) {
		int left = 0, right = lis.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (lis.get(mid) < val) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		lis.set(right, val);
	}
}
