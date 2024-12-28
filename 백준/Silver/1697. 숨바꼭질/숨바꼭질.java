import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static int K;
	private static int[] visited = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			return;
		}
		
		bfs(N);
		br.close();
	}

	private static void bfs(int X) {
		Deque<Integer> q = new ArrayDeque<>();
		visited[X] = 1;
		q.offer(X);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0)
					next = cur - 1;
				else if (i == 1)
					next = cur + 1;
				else
					next = cur * 2;

				if (next == K) {
					System.out.println(visited[cur]);
					return;
				}

				if (next >= 0 && next < visited.length && visited[next] == 0) {
					q.offer(next);
					visited[next] = visited[cur] + 1;
				}
			}
		}
	}
}
