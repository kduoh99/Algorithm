import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(br.readLine());
		System.out.println(fac(N));
		br.close();
	}

	private static long fac(long N) {
		if (N <= 1)
			return 1;
		return N * fac(N - 1);
	}
}