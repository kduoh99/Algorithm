import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final Map<String, List<Node>> graph = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int E = Integer.parseInt(br.readLine());

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String u = st.nextToken();
			String v = st.nextToken();
			long w = Long.parseLong(st.nextToken());
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Node(v, w));
		}

		long toHome = dijkstra("sasa", "home");
		long toSasa = dijkstra("home", "sasa");

		System.out.println((toHome == Long.MAX_VALUE || toSasa == Long.MAX_VALUE) ? -1 : toHome + toSasa);
		br.close();
	}

	static long dijkstra(String start, String end) {
		Map<String, Long> dist = new HashMap<>();
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.w));

		pq.offer(new Node(start, 0));
		dist.put(start, 0L);

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.w > dist.get(cur.v))
				continue;

			for (Node next : graph.getOrDefault(cur.v, Collections.emptyList())) {
				if (dist.getOrDefault(next.v, Long.MAX_VALUE) > cur.w + next.w) {
					dist.put(next.v, cur.w + next.w);
					pq.offer(new Node(next.v, cur.w + next.w));
				}
			}
		}

		return dist.getOrDefault(end, Long.MAX_VALUE);
	}
}

class Node {
	String v;
	long w;

	Node(String v, long w) {
		this.v = v;
		this.w = w;
	}
}
