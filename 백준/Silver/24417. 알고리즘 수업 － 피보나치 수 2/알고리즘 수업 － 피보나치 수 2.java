import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = 1_000_000_007;
		int N = Integer.parseInt(br.readLine());
		int ans = N - 2, x = 1, y = 1;

		for (int i = 0; i < N - 2; i++) {
			int tmp = (x + y) % M;
			x = y;
			y = tmp;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(y).append(' ').append(ans);
		System.out.println(sb);
		br.close();
	}
}