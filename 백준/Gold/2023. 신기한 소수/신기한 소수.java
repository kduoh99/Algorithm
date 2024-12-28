import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int p : genPrimes(N))
			sb.append(p).append('\n');

		System.out.println(sb);
		br.close();
	}

	private static boolean isPrime(int val) {
		for (int i = 2; i <= Math.sqrt(val); i++) {
			if (val % i == 0)
				return false;
		}
		return true;
	}

	private static List<Integer> genPrimes(int N) {
		List<Integer> primes = new ArrayList<>();
		int[] digits = { 1, 3, 7, 9 };
		primes.add(2); primes.add(3); primes.add(5); primes.add(7);

		for (int i = 1; i < N; i++) {
			List<Integer> newPrimes = new ArrayList<>();

			for (int p : primes) {
				for (int d : digits) {
					int num = p * 10 + d;

					if (isPrime(num))
						newPrimes.add(num);
				}
			}
			primes = newPrimes;
		}
		return primes;
	}
}