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

		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		dp[0] = A[0];
		int maxS = A[0];

		for (int i = 1; i < N; i++) {
			dp[i] = Math.max(A[i], dp[i - 1] + A[i]);
			maxS = Math.max(maxS, dp[i]);
		}

		System.out.println(maxS);
		br.close();
	}
}