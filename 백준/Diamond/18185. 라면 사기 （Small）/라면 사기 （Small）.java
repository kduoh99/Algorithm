import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int cost = 0;
		for (int i = 0; i < N; i++) {
			if (i < N - 2 && A[i + 1] > A[i + 2]) {
				int pack = Math.min(A[i], A[i + 1] - A[i + 2]);
				cost += 5 * pack;
				A[i] -= pack;
				A[i + 1] -= pack;
			}

			if (i < N - 2) {
				int pack = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
				cost += 7 * pack;
				A[i] -= pack;
				A[i + 1] -= pack;
				A[i + 2] -= pack;
			}

			if (i < N - 1) {
				int pack = Math.min(A[i], A[i + 1]);
				cost += 5 * pack;
				A[i] -= pack;
				A[i + 1] -= pack;
			}

			cost += 3 * A[i];
		}

		System.out.println(cost);
		br.close();
	}
}
