import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		System.out.println(phi(N));
		br.close();
	}

	private static long phi(long N) {
		long result = N;

		for (long i = 2; i * i <= N; i++) {
			if (N % i == 0) {
				while (N % i == 0)
					N /= i;
				result -= result / i;
			}
		}

		if (N > 1)
			result -= result / N;

		return result;
	}
}