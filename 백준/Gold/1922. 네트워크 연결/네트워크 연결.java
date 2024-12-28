import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static List<int[]>[] graph;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 1; i <= M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new int[] {b, c});
			graph[b].add(new int[] {a, c});
		}

		System.out.println(prim());
		br.close();
	}

	static int prim() {
		int ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		boolean[] visited = new boolean[N + 1];
		pq.offer(new int[] {1, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int weight = cur[1];

			if (visited[node]) continue;
			visited[node] = true;
			ans += weight;

			for (int[] next : graph[node]) {
				if (!visited[next[0]])
					pq.offer(next);
			}
		}
		return ans;
	}
}