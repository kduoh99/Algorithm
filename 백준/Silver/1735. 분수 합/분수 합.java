import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nA = Integer.parseInt(st.nextToken());
		int dA = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int nB = Integer.parseInt(st.nextToken());
		int dB = Integer.parseInt(st.nextToken());

		int n = nA * dB + nB * dA;
		int d = dA * dB;
		int m = gcd(n, d);

		sb.append(n / m).append(' ').append(d / m);
		System.out.println(sb);
		br.close();
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
