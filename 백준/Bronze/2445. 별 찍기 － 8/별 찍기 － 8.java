import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1 ; i <= N; i++) {
			sb.append("*".repeat(Math.max(0, i)))
				.append(" ".repeat(Math.max(0, 2 * N - i - i)))
				.append("*".repeat(Math.max(0, i))).append('\n');
		}

		for (int i = N - 1 ; i > 0; i--) {
			sb.append("*".repeat(i))
				.append(" ".repeat(Math.max(0, 2 * N - i - i)))
				.append("*".repeat(i)).append('\n');
		}

		System.out.println(sb);
		br.close();
	}
}