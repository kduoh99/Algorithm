import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static final int SIZE = 100_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[SIZE + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.offer(new int[] {N, 0});
		int time = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int X = cur[0];
			time = cur[1];
			visited[X] = true;

			if (X == K)
				break;

			if (X * 2 <= SIZE && !visited[X * 2])
				pq.offer(new int[]{X * 2, time});

			if (X + 1 <= SIZE && !visited[X + 1])
				pq.offer(new int[]{X + 1, time + 1});

			if (X - 1 >= 0 && !visited[X - 1])
				pq.offer(new int[]{X - 1, time + 1});
		}

		System.out.println(time);
		br.close();
	}
}
