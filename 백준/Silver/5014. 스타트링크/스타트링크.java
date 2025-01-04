import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int F, S, G, U, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		bfs();
	}

	private static void bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		int[] move = new int[F + 1];
		q.offer(S);
		move[S] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == G) {
				System.out.println(move[cur] - 1);
				return;
			}

			if (cur + U <= F && move[cur + U] == 0) {
				q.offer(cur + U);
				move[cur + U] = move[cur] + 1;
			}

			if (1 <= cur - D && move[cur - D] == 0) {
				q.offer(cur - D);
				move[cur - D] = move[cur] + 1;
			}
		}

		System.out.println("use the stairs");
	}
}
