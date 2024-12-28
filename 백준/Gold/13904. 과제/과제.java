import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.add(new int[] {d, w});
		}

		list.sort(Comparator.comparingInt(o -> o[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int[] p : list) {
			pq.offer(p[1]);

			if(pq.size() > p[0])
				pq.poll();
		}

		int scores = 0;
		while (!pq.isEmpty())
			scores += pq.poll();

		System.out.println(scores);
		br.close();
	}
}