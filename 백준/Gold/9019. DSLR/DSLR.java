import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX = 10_000;
	private static boolean[] visited = new boolean[MAX];
	private static int[] prev = new int[MAX];
	private static char[] op = new char[MAX];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Arrays.fill(visited, false);
			bfs(start, end);

			StringBuilder sb = new StringBuilder();
			int cur = end;
			while (cur != start) {
				sb.insert(0, op[cur]);
				cur = prev[cur];
			}
			System.out.println(sb);
		}
	}

	private static void bfs(int start, int end) {
		Deque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		prev[start] = -1;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == end) return;
			
			// D
			int next = (cur * 2) % 10000;
			if (!visited[next]) {
				visited[next] = true;
				prev[next] = cur;
				op[next] = 'D';
				q.offer(next);
			}
			// S
			next = (cur == 0) ? 9999 : cur - 1;
			if (!visited[next]) {
				visited[next] = true;
				prev[next] = cur;
				op[next] = 'S';
				q.offer(next);
			}
			// L
			next = (cur % 1000) * 10 + cur / 1000;
			if (!visited[next]) {
				visited[next] = true;
				prev[next] = cur;
				op[next] = 'L';
				q.offer(next);
			}
			// R
			next = (cur % 10) * 1000 + cur / 10;
			if (!visited[next]) {
				visited[next] = true;
				prev[next] = cur;
				op[next] = 'R';
				q.offer(next);
			}
		}
	}
}