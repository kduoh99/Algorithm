import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Long> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens())
			pq.offer(Long.parseLong(st.nextToken()));

		long x = 0, y = 0;
		for (int i = 0; i < M; i++) {
			x = pq.poll();
			y = pq.poll();

			for (int j = 0; j < 2; j++)
				pq.offer(x + y);
		}

		long ans = 0;
		while (!pq.isEmpty())
			ans += pq.poll();

		System.out.println(ans);
		br.close();
	}
}