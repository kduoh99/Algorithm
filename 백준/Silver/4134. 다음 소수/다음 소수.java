import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			long n = Long.parseLong(br.readLine());
			long nextPrime = find(n);
			sb.append(nextPrime).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

	private static long find(long n) {
		while (true) {
			if (isPrime(n)) return n;
			n++;
		}
	}

	private static boolean isPrime(long n) {
		if (n < 2) return false;

		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}