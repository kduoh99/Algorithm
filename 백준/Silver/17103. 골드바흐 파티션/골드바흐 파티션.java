import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int SIZE = 1_000_000;
	private static final boolean[] prime = new boolean[SIZE + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		prime[0] = prime[1] = true;
		for (int i = 2; i <= Math.sqrt(SIZE); i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= SIZE; j += i)
					prime[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(check(N)).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

	private static int check(int N) {
		int count = 0;

		for (int i = 2; i <= N / 2; i++) {
			if (!prime[i] && !prime[N - i])
				count++;
		}
		return count;
	}
}