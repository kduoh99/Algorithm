import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();
		String C = br.readLine();

		int A_len = A.length();
		int B_len = B.length();
		int C_len = C.length();
		int[][][] dp = new int[A_len + 1][B_len + 1][C_len + 1];

		for (int i = 1; i <= A_len; i++) {
			for (int j = 1; j <= B_len; j++) {
				for (int k = 1; k <= C_len; k++) {
					if (A.charAt(i - 1) == B.charAt(j - 1) && B.charAt(j - 1) == C.charAt(k - 1))
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					else
						dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
				}
			}
		}

		System.out.println(dp[A_len][B_len][C_len]);
		br.close();
	}
}
