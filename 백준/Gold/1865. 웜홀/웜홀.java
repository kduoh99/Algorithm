import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static final int INF = Integer.MAX_VALUE;

	private static List<Edge> edges;
	private static int[] dist;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			dist = new int[N + 1];
			edges = new ArrayList<>();

			for (int j = 1; j <= N; j++) {
				edges.add(new Edge(0, j, 0));
			}

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));
			}

			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S, E, -T));
			}

			sb.append(bellmanFord() ? "YES" : "NO").append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	private static boolean bellmanFord() {
		Arrays.fill(dist, INF);
		dist[0] = 0;

		for (int i = 1; i < N; i++) {
			for (Edge edge : edges) {
				if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
					dist[edge.to] = dist[edge.from] + edge.weight;
				}
			}
		}

		for (Edge edge : edges) {
			if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.weight) {
				return true;
			}
		}

		return false;
	}
}

class Edge {
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}
