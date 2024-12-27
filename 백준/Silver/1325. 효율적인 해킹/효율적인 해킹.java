import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static List<Integer>[] graph;
	private static boolean[] visited;
	private static int[] counter;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];
		counter = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[B].add(A);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			bfs(i);
		}

		int max = Arrays.stream(counter).max().orElse(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (counter[i] == max) {
				sb.append(i).append(' ');
			}
		}

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int start) {
		Deque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					counter[start]++;
					q.offer(next);
				}
			}
		}
	}
}
