import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static final int MOD = 10_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();

		while (N > 4) {
			N -= 3;
			q.offer(3);
		}
		q.offer(N);

		int ans = 1;
		while (!q.isEmpty()) {
			ans *= q.poll();
			ans %= MOD;
		}

		System.out.println(ans);
		br.close();
	}
}