import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	private static int N;
	private static boolean[] isPrime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		isPrime();
		List<Integer> prime = new ArrayList<>();

		for (int i = 2; i <= N; i++) {
			if (isPrime[i])
				prime.add(i);
		}

		int start = 0, end = 0, sum = 0, cnt = 0;

		while (true) {
			if (sum >= N) {
				sum -= prime.get(start++);
			} else if (end == prime.size()) {
				break;
			} else {
				sum += prime.get(end++);
			}
			if (sum == N)
				cnt++;
		}

		System.out.println(cnt);
		br.close();
	}

	private static void isPrime() {
		isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}
	}
}
