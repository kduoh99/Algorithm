import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			sb.append(countPrimes(n + 1, 2 * n)).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

	private static int countPrimes(int start, int end) {
		boolean[] prime = new boolean[end + 1];
		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(end); i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= end; j += i)
					prime[j] = true;
			}
		}
		
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (!prime[i])
				count++;
		}
		
		return count;
	}
}