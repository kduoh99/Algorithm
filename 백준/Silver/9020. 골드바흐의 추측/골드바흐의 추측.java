import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			prime = new boolean[n + 1];
			isPrime(n);

			int a = n / 2;
			int b = n / 2;

			while (true) {
				if (!prime[a] && !prime[b]) {
					sb.append(a).append(' ').append(b).append('\n');
					break;
				}
				a--;
				b++;
			}
		}
		
		System.out.println(sb);
		br.close();
	}

	private static void isPrime(int n) {
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= n; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= n; j += i)
					prime[j] = true;
			}
		}
	}
}