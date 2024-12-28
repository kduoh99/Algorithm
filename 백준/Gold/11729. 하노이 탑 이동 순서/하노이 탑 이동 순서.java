import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		move(N, 1, 3, 2);
		System.out.println((1 << N) - 1);
		System.out.println(sb);
		br.close();
	}

	private static void move(int N, int from, int to, int tmp) {
		if (N == 1) {
			sb.append(from).append(' ').append(to).append('\n');
			return;
		}
		move(N - 1, from, tmp, to);
		move(1, from, to, tmp);
		move(N - 1, tmp, to, from);
	}
}
