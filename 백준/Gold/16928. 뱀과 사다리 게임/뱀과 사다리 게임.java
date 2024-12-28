import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int[] ladder = new int[101];
	private static final int[] snake = new int[101];
	private static final int[] dist = new int[101];
	private static final boolean[] visited = new boolean[101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			ladder[x] = y;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			snake[u] = v;
		}

		bfs();
		System.out.println(dist[100]);
		br.close();
	}

	static void bfs() {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int dice = 1; dice <= 6; dice++) {
				int next = cur + dice;

				if (next > 100) continue;

				if (ladder[next] != 0)
					next = ladder[next];

				if (snake[next] != 0)
					next = snake[next];

				if (visited[next]) continue;
				visited[next] = true;
				q.offer(next);
				dist[next] = dist[cur] + 1;
			}
		}
	}
}
