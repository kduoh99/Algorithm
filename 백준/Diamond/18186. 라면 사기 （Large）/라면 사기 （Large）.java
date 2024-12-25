import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		long cost = 0L;
		for (int i = 0; i < N; i++) {
			if (C <= B && i < N - 2 && A[i + 1] > A[i + 2]) {
				int pack = Math.min(A[i], A[i + 1] - A[i + 2]);
				cost += pack * (B + C);
				A[i] -= pack;
				A[i + 1] -= pack;
			}

			if (B + 2 * C < 3 * B && i < N - 2) {
				int pack = Math.min(A[i], Math.min(A[i + 1], A[i + 2]));
				cost += pack * (B + 2L * C);
				A[i] -= pack;
				A[i + 1] -= pack;
				A[i + 2] -= pack;
			}

			if (B + C < 2 * B && i < N - 1) {
				int pack = Math.min(A[i], A[i + 1]);
				cost += pack * (B + C);
				A[i] -= pack;
				A[i + 1] -= pack;
			}

			cost += A[i] * B;
		}

		System.out.println(cost);
		br.close();
	}
}
