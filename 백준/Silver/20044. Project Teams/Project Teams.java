import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N * 2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 2 * N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(A);
		int ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int sum = A[i] + A[2 * N - 1 - i];

			if (ans > sum)
				ans = sum;
		}

		System.out.println(ans);
		br.close();
	}
}