import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int N;
	private static ArrayList<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph[A].add(new int[] {B, C});
			graph[B].add(new int[] {A, C});
		}

		dijkstra(1);
		br.close();
	}

	static void dijkstra(int start) {
		int[] dist = new int[N + 1];
		int[] parent = new int[N + 1];
		int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int curIdx = cur[0];
			int curTime = cur[1];

			if (curTime > dist[curIdx])
				continue;

			for (int[] next : graph[curIdx]) {
				int nextIdx = next[0];
				int nextTime = next[1];

				if (dist[nextIdx] > curTime + nextTime) {
					dist[nextIdx] = curTime + nextTime;
					pq.offer(new int[]{nextIdx, dist[nextIdx]});
					parent[nextIdx] = curIdx;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int K = 0;
		for (int i = 1; i <= N; i++) {
			if (i != start && parent[i] != 0) {
				sb.append(i).append(' ').append(parent[i]).append('\n');
				K++;
			}
		}

		System.out.println(K);
		System.out.println(sb);
	}
}
