import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 10_000_000;
	private static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		prime = new boolean[SIZE + 1];
		isPrime();
		int cnt = 0;

		for (int i = 2; i <= SIZE; i++) {
			if (!prime[i]) {
				long num = (long) i * i;

				while (num <= B) {
					if (num >= A)
						cnt++;
					if (num > Long.MAX_VALUE / i)
						break;
					num *= i;
				}
			}
		}
		
		System.out.println(cnt);
		br.close();
	}

	private static void isPrime() {
		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= SIZE; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= SIZE; j += i)
					prime[j] = true;
			}
		}
	}
}
