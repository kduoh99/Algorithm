import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[10];

		for (int i = 0; i < 10; i++)
			dp[i] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j < 10; j++)
				dp[j] = (dp[j] + dp[j - 1]) % 10007;
		}

		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[i];
			sum %= 10007;
		}

		System.out.println(sum);
		br.close();
	}
}