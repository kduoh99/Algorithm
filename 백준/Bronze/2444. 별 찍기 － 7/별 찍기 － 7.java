import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; ++i) {
			sb.append(" ".repeat(Math.max(0, N - i)))
				.append("*".repeat(Math.max(0, 2 * i - 1))).append("\n");
		}
		for (int i = N-1; i >= 1; --i) {
			sb.append(" ".repeat(Math.max(0, N - i)))
				.append("*".repeat(Math.max(0, 2 * i - 1))).append("\n");
		}
		bw.write(sb + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}