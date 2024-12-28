import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String A = br.readLine();
		String B = br.readLine();

		int A_len = A.length();
		int B_len = B.length();
		int[][] dp = new int[A_len + 1][B_len + 1];

		for (int i = 1; i <= A_len; i++) {
			for (int j = 1; j <= B_len; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		int LCS_len = dp[A_len][B_len];
		sb.append(LCS_len).append('\n');

		if (LCS_len != 0) {
			int i = A_len;
			int j = B_len;
			StringBuilder LCS = new StringBuilder();

			while (i > 0 && j > 0) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					LCS.append(A.charAt(i - 1));
					i--;
					j--;
				}
				else if (dp[i - 1][j] > dp[i][j - 1])
					i--;
				else
					j--;
			}
			sb.append(LCS.reverse());
		}

		System.out.print(sb);
		br.close();
	}
}
