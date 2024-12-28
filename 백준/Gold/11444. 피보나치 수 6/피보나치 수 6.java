import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final long MOD = 1_000_000_007L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		System.out.println(fib(n));
		br.close();
	}

	private static long fib(long n) {
		if (n <= 1) return n;
		long[][] origin = {{1, 1}, {1, 0}};
		long[][] result = {{1, 0}, {0, 1}};

		while (n > 0) {
			if ((n & 1) == 1) {
				result = mul(result, origin);
			}
			origin = mul(origin, origin);
			n >>= 1;
		}

		return result[0][1];
	}

	private static long[][] mul(long[][] a, long[][] b) {
		long[][] result = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
				}
			}
		}
		return result;
	}
}
