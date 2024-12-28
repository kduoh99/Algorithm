import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int M = Integer.parseInt(br.readLine());
			sb.append((M + 1) / 2).append('\n');

			PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			int cnt = 0;

			for (int i = 0; i < M; i++) {
				if (i % 10 == 0)
					st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());

				if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
					maxHeap.offer(num);
				} else {
					minHeap.offer(num);
				}
				
				while (maxHeap.size() > minHeap.size() + 1)
					minHeap.offer(maxHeap.poll());

				while (minHeap.size() > maxHeap.size())
					maxHeap.offer(minHeap.poll());

				if (i % 2 == 0) {
					sb.append(maxHeap.peek()).append(' ');
					cnt++;

					if (cnt % 10 == 0)
						sb.append('\n');
				}
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}
}