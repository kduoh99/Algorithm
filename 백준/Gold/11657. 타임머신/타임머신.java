import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static ArrayList<int[]> graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			graph.add(new int[] {A, B, C});
		}

		bellmanFord();
		br.close();
	}

	private static void bellmanFord() {
		long[] dist = new long[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M; j++) {
				int[] cur = graph.get(j);
				int curA = cur[0], curB = cur[1], curC = cur[2];

				if (dist[curA] != Integer.MAX_VALUE && dist[curB] > dist[curA] + curC)
					dist[curB] = dist[curA] + curC;
			}
		}

		for (int i = 0; i < M; i++) {
			int[] cur = graph.get(i);
			int curA = cur[0], curB = cur[1], curC = cur[2];

			if (dist[curA] != Integer.MAX_VALUE && dist[curB] > dist[curA] + curC) {
				System.out.println(-1);
				return;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < dist.length; i++)
			sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]).append('\n');

		System.out.println(sb);
	}
}
