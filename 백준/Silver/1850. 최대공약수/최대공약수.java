import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long digit = gcd(A, B);
		StringBuilder sb = new StringBuilder();
		
		while (digit > 0) {
			sb.append('1');
			digit--;
		}

		System.out.println(sb);
		br.close();
	}

	private static long gcd(long A, long B) {
		if (B == 0)
			return A;
		else
			return gcd(B, A % B);
	}
}