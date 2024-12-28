import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] A, lisA, ldsA;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		lisA = new int[N];
		ldsA = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		lis();
		lds();

		int max = 0;
		for (int i = 0; i < N; i++)
			max = Math.max(max, lisA[i] + ldsA[i]);

		System.out.println(max - 1);
		br.close();
	}
	
	private static void lis() {
		for (int i = 0; i < N; i++) {
			lisA[i] = 1;

			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && lisA[i] < lisA[j] + 1)
					lisA[i] = lisA[j] + 1;
			}
		}
	}

	private static void lds() {
		for (int i = N - 1; i >= 0; i--) {
			ldsA[i] = 1;

			for (int j = N - 1; j > i; j--) {
				if (A[j] < A[i] && ldsA[i] < ldsA[j] + 1)
					ldsA[i] = ldsA[j] + 1;
			}
		}
	}
}
