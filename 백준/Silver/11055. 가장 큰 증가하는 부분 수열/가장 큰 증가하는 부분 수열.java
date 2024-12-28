import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] A, lisA;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];
		lisA = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		lis();

		int max = 0;
		for (int i = 0; i < N; i++)
			max = Math.max(max, lisA[i]);

		System.out.println(max);
		br.close();
	}

	private static void lis() {
		for (int i = 0; i < N; i++) {
			lisA[i] = A[i];

			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && lisA[i] < lisA[j] + A[i])
					lisA[i] = lisA[j] + A[i];
			}
		}
	}
}
