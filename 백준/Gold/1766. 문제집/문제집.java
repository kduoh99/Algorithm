import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer>[] graph;
	private static int[] indegree;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		indegree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A].add(B);
			graph[B].add(A);
			indegree[B]++;
		}

		topologySort();
		br.close();
	}

	private static void topologySort() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				pq.offer(i);
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur).append(' ');

			for (int next : graph[cur]) {
				indegree[next]--;
				if (indegree[next] == 0)
					pq.offer(next);
			}
		}

		System.out.println(sb);
	}
}
