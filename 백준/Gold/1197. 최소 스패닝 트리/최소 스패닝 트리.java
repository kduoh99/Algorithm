import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int V;
	private static List<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			graph[i] = new ArrayList<>();

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new int[] {B, C});
			graph[B].add(new int[] {A, C});
		}

		System.out.println(prim());
		br.close();
	}

	private static int prim() {
		int ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		boolean[] visited = new boolean[V + 1];
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
