import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<int[]> lectures = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			lectures.add(new int[] {p, d});
		}

		lectures.sort((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int ans = 0, idx = 0;
		int maxDay = lectures.stream().mapToInt(l -> l[1]).max().orElse(0);

		for (int day = maxDay; day > 0; day--) {
			while (idx < n && lectures.get(idx)[1] >= day) {
				pq.offer(lectures.get(idx)[0]);
				idx++;
			}

			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}

		System.out.println(ans);
		br.close();
	}
}
