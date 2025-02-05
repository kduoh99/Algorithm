import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = N ; i > 0; i--) {
			sb.append(" ".repeat(Math.max(0, N - i)))
				.append("*".repeat(Math.max(0, 2 * i - 1))).append('\n');
		}

		for (int i = 2 ; i <= N; i++) {
			sb.append(" ".repeat(Math.max(0, N - i)))
				.append("*".repeat(Math.max(0, 2 * i - 1))).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}