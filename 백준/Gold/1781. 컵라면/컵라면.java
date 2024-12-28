import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int deadLine = Integer.parseInt(st.nextToken());
			int ramenCnt = Integer.parseInt(st.nextToken());
			list.add(new int[] {deadLine, ramenCnt});
		}

		list.sort((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int[] cur : list) {
			pq.offer(cur[1]);
			if (pq.size() > cur[0])
				pq.poll();
		}

		int ans = 0;
		while (!pq.isEmpty()) {
			ans += pq.poll();
		}

		System.out.println(ans);
		br.close();
	}
}
