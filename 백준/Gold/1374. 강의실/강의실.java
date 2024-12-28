import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<int[]> room = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			room.add(new int[] {num, start, end});
		}
		
		room.sort(Comparator.comparingInt(o -> o[1]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int max = 1;

		for (int i = 0; i < N; i++) {
			while (!pq.isEmpty() && pq.peek() <= room.get(i)[1]) {
				pq.poll();
			}
			pq.offer(room.get(i)[2]);
			max = Math.max(max, pq.size());
		}

		System.out.println(max);
		br.close();
	}
}
