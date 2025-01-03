import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		System.out.println(N > 1022 ? -1 : bfs());
		br.close();
	}

	private static long bfs() {
		Deque<Long> q = new ArrayDeque<>();
		for (long i = 0; i <= 9; i++) {
			q.offer(i);
		}

		long ans = 0;
		int cnt = 0;

		while (!q.isEmpty()) {
			long cur = q.poll();
			ans = cur;

			if (cnt == N) break;
			cnt++;

			long last = cur % 10;
			for (long next = 0; next < last; next++) {
				q.offer(cur * 10 + next);
			}
		}

		return ans;
	}
}
