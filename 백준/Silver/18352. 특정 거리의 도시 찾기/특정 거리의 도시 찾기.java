import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
		}

		bfs(X);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K) {
				sb.append(i).append('\n');
			}
		}

		System.out.println(sb.length() == 0 ? -1 : sb);
		br.close();
	}

	private static void bfs(int X) {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(X);
		dist[X] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					q.offer(next);
				}
			}
		}
	}
}
