import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken());

			if (h > o) {
				int tmp = h;
				h = o;
				o = tmp;
			}
			list.add(new int[] {h, o});
		}

		int d = Integer.parseInt(br.readLine());
		list.sort(Comparator.comparingInt(a -> a[1]));

		int count = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int[] li : list) {
			int start = li[0], end = li[1];
			if (end - start > d)
				continue;

			pq.offer(start);
			while (!pq.isEmpty() && pq.peek() < end - d) {
				pq.poll();
			}
			count = Math.max(count, pq.size());
		}

		System.out.println(count);
		br.close();
	}
}
