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
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(findYear(M, N, x, y)).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

	private static int findYear(int M, int N, int x, int y) {
		int maxYear = lcm(M, N);

		for (int i = x; i <= maxYear; i += M) {
			int tmpY = (i % N == 0) ? N : i % N;
			if (tmpY == y) return i;
		}
		return -1;
	}

	private static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		while (b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}