import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sb.append(lcm(A, B)).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

	private static int gcd(int A, int B) {
		while (B > 0) {
			int tmp = A;
			A = B;
			B = tmp % B;
		}
		return A;
	}

	private static int lcm(int A, int B) {
		return A * B / gcd(A, B);
	}
}