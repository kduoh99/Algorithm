import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] C = new int[N];

		for (int i = 0; i < N; i++)
			C[i] = Integer.parseInt(br.readLine());

		int gcd = 0;
		for (int i = 0; i < N - 1; i++) {
			int d = C[i + 1] - C[i];
			gcd = gcd(d, gcd);
		}
		
		System.out.println((C[N - 1] - C[0]) / gcd + 1 - (C.length));
		br.close();
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}