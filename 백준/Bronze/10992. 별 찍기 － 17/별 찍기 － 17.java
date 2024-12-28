import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i < N; i++) {
			sb.append(" ".repeat(N - i)).append('*')
				.append(" ".repeat(Math.max(0, 2 * (i - 1) - 1)));

			if (i > 1)
				sb.append('*');
			sb.append('\n');
		}

		sb.append("*".repeat(Math.max(0, 2 * N - 1)));
		System.out.println(sb);
		br.close();
	}
}