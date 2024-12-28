import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
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

		System.out.println(dp[A_len][B_len]);
		br.close();
	}
}
